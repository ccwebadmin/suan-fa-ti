package com.leetcode1.com.other;

import java.math.BigDecimal;

/**
 * @author cc
 * @date 2021/11/8-17:26
 */
public class StringTest {

    public static void main(String[] args) {
        BigDecimal OthfundPay = BigDecimal.ZERO;
        System.out.println(OthfundPay.equals(BigDecimal.ZERO));


        String localFund ="99999737";
        System.out.println(StringTest.getNatFund(localFund));
    }
    public static String getNatFund(String localFund) {
        switch (localFund) {
            case "310100"://职工基本医疗保险统筹基金
            case "310200"://职工基本医疗保险个人账户基金
            case "320100"://公务员医疗补助基金
            case "350100"://一至六级残疾军人医疗保障基金
            case "370100"://企业补充医疗保险基金
            case "390100"://城乡居民基本医疗保险基金
            case "610100"://医疗救助基金
                return localFund;
            case "99999737"://职工大病补助基金
            case "390200"://城乡居民大病医疗保险基金
                return "330100";
            default://其他
                return "910100";
        }

    }
}
