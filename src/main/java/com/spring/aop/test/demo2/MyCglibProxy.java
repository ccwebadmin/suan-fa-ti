package com.spring.aop.test.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor{

    private ProductDao productDao;

    public MyCglibProxy(ProductDao productDao){
        this.productDao = productDao;
    }

    public Object createProxy(){
        // 1.创建核心类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(productDao.getClass());
        // 3.设置回调
        enhancer.setCallback(this);
        // 4.生成代理
        Object proxy = enhancer.create();
        return proxy;
    }

    /**
     * 调用目标方法 cglib调用该接口方法拦截
     *
     * @param proxy  生产的代理类实例
     * @param method 被代理的实体类中的方法引用
     * @param args 方法参数值列表
     * @param methodProxy 生成的代理类对方法代理的引用
     * @return 代理实例的方法调用返回值
     *
     * @author caicheng
     * @date 2021/10/31 10:37
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if("save".equals(method.getName())){
            System.out.println("权限校验===================");
            return methodProxy.invokeSuper(proxy,args);
        }
        return methodProxy.invokeSuper(proxy,args);
    }
}
