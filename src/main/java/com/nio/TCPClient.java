package com.nio;

/**
 * @Description
 * @Author cc
 * @Date 2025年05月16日 14:28
 */

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try (Socket socket = new Socket("localhost", 8080);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // 发送消息给服务器
                out.println("Hello, server!");

                // 接收服务器的响应
                String response = in.readLine();
                System.out.println("Server response: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
