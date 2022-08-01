package com.yida.architect.tcp.code.ser;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(20000);

        Socket accept = socket.accept();

        InputStream inputStream = accept.getInputStream();
        int b;
        while ((b = inputStream.read()) != -1) {
            System.out.print((char) b);
        }
        inputStream.close();
        socket.close();
    }
}
