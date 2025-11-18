package com.util;

/**
 *
 * @author cc
 * @date 2025年11月18日 11:46
 * @return
 */
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CharsetRecoveryUtil {

    // 常见的编码集合，用于自动尝试
    private static final List<String> COMMON_CHARSETS = new ArrayList<>();

    static {
        // 添加上下文提到的常见编码
        COMMON_CHARSETS.add("UTF-8");
        COMMON_CHARSETS.add("GBK");
        COMMON_CHARSETS.add("GB2312");
        COMMON_CHARSETS.add("ISO-8859-1");
        COMMON_CHARSETS.add("windows-1252");
        COMMON_CHARSETS.add("GB18030");
    }

    /**
     * 尝试将乱码字符串恢复为正确的中文
     * @param garbledText 乱码文本
     * @param wrongCharset 导致乱码的错误编码 (例如: "GBK")
     * @param correctCharset 原始的正确编码 (例如: "UTF-8")
     * @return 恢复后的正确文本，如果恢复失败则返回 null
     */
    public static String recoverGarbledText(String garbledText, String wrongCharset, String correctCharset) {
        if (garbledText == null || garbledText.isEmpty()) {
            return garbledText;
        }
        try {
            // 1. 使用错误的编码将乱码字符串编码回字节数组
            byte[] bytes = garbledText.getBytes(wrongCharset);

            // 2. 使用正确的编码解码字节数组
            return new String(bytes, correctCharset);
        } catch (UnsupportedEncodingException e) {
            System.err.println("不支持的编码格式: " + wrongCharset + " 或 " + correctCharset);
            // e.printStackTrace();
            return null;
        }
    }

    /**
     * 自动尝试所有常见的编码组合，寻找可能的正确结果
     * @param garbledText 乱码文本
     */
    public static void tryAllPossibleEncodings(String garbledText) {
        if (garbledText == null || garbledText.isEmpty()) {
            System.out.println("输入文本为空。");
            return;
        }

        System.out.println("正在尝试所有常见编码组合来恢复乱码 \"" + garbledText + "\"...");
        System.out.println("--------------------------------------------------");

        boolean found = false;
        // 遍历所有可能的"错误编码"
        for (String wrongCharset : COMMON_CHARSETS) {
            // 遍历所有可能的"正确编码"
            for (String correctCharset : COMMON_CHARSETS) {
                // 跳过相同的编码组合，它们不会产生乱码
                if (wrongCharset.equals(correctCharset)) {
                    continue;
                }

                try {
                    String recovered = recoverGarbledText(garbledText, wrongCharset, correctCharset);
                    if (recovered != null) {
                        System.out.printf("【可能结果】错误编码: %-12s 正确编码: %-12s 恢复结果: %s%n",
                                wrongCharset, correctCharset, recovered);
                        found = true;
                    }
                } catch (Exception e) {
                    // 忽略任何异常，继续尝试下一个组合
                }
            }
        }

        if (!found) {
            System.out.println("未能找到有效的恢复组合。");
        }
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        // 示例 1: UTF-8 文本被错误地以 GBK 打开
        String original1 = "你好，世界！";
        String garbled1 = null;
        try {
            // 模拟乱码产生过程
            garbled1 = new String(original1.getBytes("UTF-8"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("示例 1 - 乱码文本: " + garbled1);
        String recovered1 = recoverGarbledText(garbled1, "GBK", "UTF-8");
        System.out.println("示例 1 - 恢复结果: " + recovered1);
        System.out.println();

        // 示例 2: GBK 文本被错误地以 UTF-8 打开
        String original2 = "Java编码问题解决";
        String garbled2 = null;
        try {
            garbled2 = new String(original2.getBytes("GBK"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("示例 2 - 乱码文本: " + garbled2);
        String recovered2 = recoverGarbledText(garbled2, "UTF-8", "GBK");
        System.out.println("示例 2 - 恢复结果: " + recovered2);
        System.out.println();

        // 示例 3: 一个真实的乱码，让程序自动尝试恢复
        String realGarbled = "µ÷ÓÃCSBÍø¹زéѯӰÏñË÷ÒýÐÅϢʧ°ܣ¬Çë¼ì²é"; 
        System.out.println("示例 3 - 待恢复的乱码: " + realGarbled);
        tryAllPossibleEncodings(realGarbled);
    }
}
