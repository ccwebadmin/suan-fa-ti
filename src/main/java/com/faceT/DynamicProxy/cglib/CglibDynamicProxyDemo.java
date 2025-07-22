package com.faceT.DynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月21日 15:24
 */
public class CglibDynamicProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback(new ServiceMethodInterceptor());

        Service proxy = (Service) enhancer.create();
        proxy.perform();
    }
}
