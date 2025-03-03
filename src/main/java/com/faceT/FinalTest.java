package com.faceT;

/**
 * @Description
 * @Author cc
 * @Date 2025年01月20日 15:53
 */
public  class  FinalTest {
    private final int i = 0;
    private final int j=1;

      int k =1;


    private static final int m =2;

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        finalTest.k=2;
        System.out.println(finalTest.k);

        System.out.println(m);
    }
}
