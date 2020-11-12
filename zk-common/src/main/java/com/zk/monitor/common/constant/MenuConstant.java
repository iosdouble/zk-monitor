package com.zk.monitor.common.constant;

/**
 * com.zk.monitor.common.constant
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 菜单常量
 **/
public class MenuConstant {

    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
