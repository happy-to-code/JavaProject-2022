package com.yida.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    static public void main(String args[]) throws Exception {
        FileInputStream fin = new FileInputStream("C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\nio\\test.txt");
        // 获取通道
        FileChannel fc = fin.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取数据到缓冲区
        fc.read(buffer);
        buffer.flip();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.print(((char) b));
        }
        fin.close();
    }
}
