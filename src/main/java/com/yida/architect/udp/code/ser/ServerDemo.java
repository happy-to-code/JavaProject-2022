package com.yida.architect.udp.code.ser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ds.receive(dp);

        byte[] data = dp.getData();

        System.out.println("data.toString() = " + data.toString());
        System.out.println("data.toString() = " + new String(data));
        System.out.println("data.toString() = " + new String(data, 0, dp.getLength()));
        System.out.println("data.toString() = " + new String(bytes, 0, dp.getLength()));
        ds.close();
    }
}
