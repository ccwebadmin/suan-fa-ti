package com.faceT.DynamicProxy;

import java.lang.reflect.InvocationHandler;

/**
 * @Description jdk 动态代理
 */
public class ServiceInvocationHandler implements InvocationHandler {
    private final Object target;
    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(target, args);
        System.out.println("after invoke");
        return result;
    }
}
