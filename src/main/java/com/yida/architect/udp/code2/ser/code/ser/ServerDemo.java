package com.yida.architect.udp.code2.ser.code.ser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);

        while (true){
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            byte[] data = dp.getData();
            System.out.println("聊天数据 = " + new String(data, 0, dp.getLength()));
        }
    }
}
