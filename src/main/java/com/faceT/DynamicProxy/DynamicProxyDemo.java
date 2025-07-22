package com.faceT.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月21日 11:43
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Service target = new ServiceImpl();
        //创建代理对象
        Service proxy = (Service) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ServiceInvocationHandler(target)
        );

        proxy.perform();
    }
}
