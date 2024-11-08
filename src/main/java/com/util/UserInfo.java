package com.util;


import java.util.Date;

public class UserInfo {
    private Date lastLogin;
    private String name;
    public UserInfo(Date lastLogin,String name) {
        this.lastLogin = lastLogin;
        this.name=name;
    }
    public Date getLastLogin() {
        return (Date)lastLogin.clone(); // 返回私有可变类成员的引用
    }
    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        Date loginDate = new Date(); // 当前时间
        UserInfo user = new UserInfo(loginDate,"张三");

        Date lastLogin = user.getLastLogin();
        String name = user.getName();
        System.out.println("上次登录时间：" + lastLogin);

        // 恶意修改用户的上次登录时间
        lastLogin.setTime(0);

        System.out.println("上次登录时间：" + user.getLastLogin()); // 输出结果表明用户的上次登录时间被恶意修改
        System.out.println("姓名：" + user.getName()); // 输出结果表明用户的上次登录时间被恶意修改
    }
}