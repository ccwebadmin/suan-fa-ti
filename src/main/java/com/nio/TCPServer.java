package com.nio;
import java.io.*;
import java.net.*;

/**
 * @Description
 * @Author cc
 * @Date 2025年05月15日 20:00
 */
public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                //异步处理，优化可以用线程池
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
