package com.yida.pic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class ImageDemo {
    public void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {

        try {
            // 读取原图片信息
            //得到文件
            File srcImgFile = new File(srcImgPath);
            //文件转化为图片
            Image srcImg = ImageIO.read(srcImgFile);
            //获取图片的宽
            int srcImgWidth = srcImg.getWidth(null);
            //获取图片的高
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            //根据图片的背景设置水印颜色
            g.setColor(markContentColor);
            //设置字体
            g.setFont(font);

            //设置水印的坐标
            //int x = srcImgWidth - 2*getWatermarkLength(waterMarkContent, g)
            //int y = srcImgHeight - 2*getWatermarkLength(waterMarkContent, g)
            int x = 350;
            int y = 350;
            //画出水印
            g.drawString(waterMarkContent, x, y);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("添加水印完成");
            outImgStream.flush();
            outImgStream.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    public static void main(String[] args) {
        //水印字体
        Font font = new Font("微软雅黑", Font.PLAIN, 45);
        //源图片地址
        String srcImgPath = "C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\pic\\nice.jpg";
        //待存储的地址
        String tarImgPath = "C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\pic\\cc.jpg";
        //水印内容
        String waterMarkContent = "水印内容。。。。。。。。";
        //水印图片色彩以及 透明度
        Color color = new Color(0, 0, 0, 255);
        new ImageDemo().addWaterMark(srcImgPath, tarImgPath, waterMarkContent, color, font);

    }
}
