package com.yida.architect.udp.code2.ser.code.cli;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if ("886".equals(s)){
                break;
            }
            byte[] bytes = s.getBytes();
            InetAddress inetAddress = InetAddress.getByName("yida");
            int port = 10000;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inetAddress, port);

            ds.send(dp);

        }
        ds.close();

    }
}
