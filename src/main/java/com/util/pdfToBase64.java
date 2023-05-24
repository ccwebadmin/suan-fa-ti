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
//        String str ="123";
//        String[] st =str.split(",");
//        System.out.println(st.length);
//        System.out.println(st[0]);
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
        String path="C:\\Users\\24234\\Desktop\\新建文件夹\\mac通过虚拟机连接vpn.pdf";
        File file=new File(path);
        byte[] bytes=getBytesByFile(file);
        String fileBase64=Base64.encode(bytes);
        //本地文件
        String filePath = "C:/Users/24234/Desktop/pdfbase64.txt"; // 存储文件的路径和文件名

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(fileBase64); // 将字符串写入文件
            fileWriter.close(); // 记得关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }

        upload(Base64.decode(fileBase64),"D://","共产党宣言.pdf");
    }
}
