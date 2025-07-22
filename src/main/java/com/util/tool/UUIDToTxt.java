package com.util.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author cc
 * @date 2025年06月17日 10:27
 * @return
 */
public class UUIDToTxt {
    public static void main(String[] args) throws IOException {
        String FilePath = "C:\\Users\\Lenovo\\Desktop\\mbs\\uuid.txt";
        FileOutputStream fos = new FileOutputStream(new File(FilePath));
        for (int i = 1; i <=607 ; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //换行
            fos.write(uuid.getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();

    }
}
