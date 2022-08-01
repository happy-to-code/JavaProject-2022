package com.yida.architect.udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddrDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("yida");
        byte[] address = inetAddress.getAddress();
        System.out.println("address.toString() = " + address.toString());

        String hostName = inetAddress.getHostName();
        System.out.println("hostName = " + hostName);

        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);
    }
}
