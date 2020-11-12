package com.zk.monitor.modules.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zk.monitor.common.exception.ValidateCodeException;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.modules.security.code.sms.SmsCodeService;
import com.zk.monitor.modules.security.social.PreConnectionData;
import com.zk.monitor.modules.security.social.SocialRedisHelper;
import com.zk.monitor.modules.security.social.SocialUserInfo;
import com.zk.monitor.modules.sys.domain.SysUser;
import com.zk.monitor.modules.sys.dto.UserDTO;
import com.zk.monitor.modules.sys.service.ISysUserService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class IndexController {

    @Autowired
    private ISysUserService userService;


    @Autowired
    private SmsCodeService smsCodeService;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private SocialRedisHelper socialRedisHelper;

    @Value("${pre.url.address}")
    private String url;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @PostMapping("/register")
    public AjaxResult register(@RequestBody UserDTO userDTO) {
        Object redisCode = redisTemplate.opsForValue().get(userDTO.getPhone());
        if (ObjectUtil.isNull(redisCode)) {
            throw new ValidateCodeException("验证码已失效");
        }
        if (!userDTO.getSmsCode().toLowerCase().equals(redisCode)) {
            throw new ValidateCodeException("短信验证码错误");
        }
        return AjaxResult.ok(userService.register(userDTO));
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        // 社交快速登录
        String token = request.getParameter("token");
        if (StrUtil.isNotEmpty(token)) {
            return AjaxResult.ok(token);
        }
        return AjaxResult.ok(userService.login(username, password));
    }

    /**
     * 保存完信息然后跳转到绑定用户信息页面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/socialSignUp")
    public void socialSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uuid = UUID.randomUUID().toString();
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connectionFromSession = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setHeadImg(connectionFromSession.getImageUrl());
        userInfo.setNickname(connectionFromSession.getDisplayName());
        userInfo.setProviderId(connectionFromSession.getKey().getProviderId());
        userInfo.setProviderUserId(connectionFromSession.getKey().getProviderUserId());
        ConnectionData data = connectionFromSession.createData();
        PreConnectionData preConnectionData = new PreConnectionData();
        BeanUtil.copyProperties(data, preConnectionData);
        socialRedisHelper.saveConnectionData(uuid, preConnectionData);
        // 跳转到用户绑定页面
        response.sendRedirect(url + "/bind?key=" + uuid);
    }

    /**
     * 社交登录绑定
     *
     * @param user
     * @return
     */
    @PostMapping("/bind")
    public AjaxResult register(@RequestBody SysUser user) {
        return AjaxResult.ok(userService.doPostSignUp(user));
    }


    /**
     * @Author 李号东
     * @Description 暂时这样写
     * @Date 08:12 2019-06-22
     **/
    @RequestMapping("/info")
    public AjaxResult info() {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("admin");
        map.put("roles", list);
        map.put("avatar", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561394014552&di=17b6c1233048e5276f48309b306c7699&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F29%2F20180429210111_gtsnf.jpg");
        map.put("name", "Super Admin");
        return AjaxResult.ok(map);
    }

    /**
     * @Author 李号东
     * @Description 使用jwt前后分离 只需要前端清除token即可 暂时返回success
     * @Date 08:13 2019-06-22
     **/
    @RequestMapping("/logout")
    public String logout() {
        return "success";
    }
}
