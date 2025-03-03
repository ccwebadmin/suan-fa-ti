package com.faceT;

/**
 * @Description
 * @Author cc
 * @Date 2025年01月20日 16:16
 */
public class FinalTestSub extends FinalTest{
    public void test(){
        System.out.println("子类方法");
    }

    public static void main(String[] args) {
        FinalTestSub finalTestSub = new FinalTestSub();
        finalTestSub.k=2;
        System.out.println(finalTestSub.k);
        char[] buf = new char[]{'a','b','c'};
//        new String(buf,true)
    }
}
