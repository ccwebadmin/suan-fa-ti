package com.util;

public class ErrorMessageExtractor {

    public static void main(String[] args) {
        String input = "Error message: An error occurred., Stack trace: [stack trace goes here]";
        String errorMessage = extractErrorMessage(input);
        System.out.println("Error Message: " + errorMessage);
    }

    public static String extractErrorMessage(String input) {
        // 查找错误信息的起始位置
        int start = input.indexOf("Error message: ");
        if (start == -1) {
            return "Error message not found";
        }

        // 截取错误信息的起始位置
        start += "Error message: ".length();

        // 查找错误信息的结束位置
        int end = input.indexOf(", Stack trace: ");
        if (end == -1) {
            return "Error message not complete";
        }

        // 截取错误信息部分
        String errorMessage = input.substring(start, end);
        return errorMessage;
    }
}