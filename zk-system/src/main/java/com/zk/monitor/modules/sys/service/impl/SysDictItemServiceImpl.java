package com.zk.monitor.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.monitor.modules.sys.domain.SysDictItem;
import com.zk.monitor.modules.sys.mapper.SysDictItemMapper;
import com.zk.monitor.modules.sys.service.ISysDictItemService;
import org.springframework.stereotype.Service;

@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {
}
