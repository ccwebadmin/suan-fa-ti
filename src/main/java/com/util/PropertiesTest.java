package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author cc
 * @date 2023/10/25-19:28
 */
public class PropertiesTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties pps = new Properties();
        //ClassLoader是Java中用于加载类和资源的机制之一，它负责在运行时查找和加载类文件
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        //获取指定资源的输入流,resources目录下
        InputStream inputStream = classLoader.getResourceAsStream("test.properties");
        pps.load(inputStream);
        Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
            //封装到JavaBean。
        }
    }
}
