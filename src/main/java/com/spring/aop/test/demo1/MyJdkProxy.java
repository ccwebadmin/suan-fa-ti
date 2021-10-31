package com.spring.aop.test.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJdkProxy implements InvocationHandler{
    private UserDao userDao;

    public MyJdkProxy(UserDao userDao){
        this.userDao = userDao;
    }

    //创建代理类
    public Object createProxy(){
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName())){
            System.out.println("权限校验...");
            return method.invoke(userDao,args);
        }
        return method.invoke(userDao,args);
    }
}
