package com.util;

import cn.hutool.core.codec.Base64;

import java.io.*;
import java.nio.file.Files;

/**
 * @author cc
 * @date 2023/3/25-13:55
 */
public class pdfToBase64 {
    public static void main(String[] args) throws IOException {
//        String encode = Base64.encode(a);
    //        File file = new File("D:\\desktop\\image\\参保报错截图Test.pdf");
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
//            String b64 = "JVBERi0xLjUKJYCBgoMKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvRmlyc3QgMTQxL04gMjAvTGVuZ3==";
//            byte[] decoder = Base64.getDecoder().decode(b64);
//            fos.write(decoder);
//            System.out.println("PDF File Saved");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        test1();
    }

    /**
     * 将file文件转换成Byte数组
     * @param file 转换文件
     * @return Byte数组
     */
    public static byte[] getBytesByFile(File file) throws IOException {
        FileInputStream fis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            byte[] data = bos.toByteArray();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                fis.close();
            }
            bos.close();
        }
        return null;
    }

    /**
     * @param bytes byte数组
     * @param fileRoute 文件路径
     * @param fileName 文件名
     */
    public static void upload(byte[] bytes,String fileRoute,String fileName) {
        try {
            File directory=new File(fileRoute);
            if (!directory.exists()){
                directory.mkdirs();
            }
            File file = new File(directory, fileName);
            BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
            bos.write(bytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1() throws IOException {
        String path="D:\\desktop\\image\\空白.pdf";
        File file=new File(path);
        byte[] bytes=getBytesByFile(file);
        String fileBase64=Base64.encode(bytes);
        System.out.println(fileBase64);
        upload(Base64.decode(fileBase64),"D://","共产党宣言.pdf");
    }
}
