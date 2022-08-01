package com.yida.architect.udp.code.cli;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "Hello,world";
        byte[] bytes = s.getBytes();
        InetAddress inetAddress = InetAddress.getByName("yida");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inetAddress, port);

        ds.send(dp);

        ds.close();

    }
}
