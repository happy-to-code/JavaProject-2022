package com.yida.architect.tcp.code.cli;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 20000);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes(StandardCharsets.UTF_8));

        outputStream.close();
        socket.close();
    }
}
