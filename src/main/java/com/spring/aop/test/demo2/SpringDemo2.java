package com.spring.aop.test.demo2;

import org.junit.Test;

public class SpringDemo2 {

    @Test
    public void demo1(){
        ProductDao productDao = new ProductDao();
        //目标类代理
        ProductDao proxy = (ProductDao) new MyCglibProxy(productDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
