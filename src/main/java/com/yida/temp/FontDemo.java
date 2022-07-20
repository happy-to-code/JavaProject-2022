package com.yida.temp;

import java.awt.*;

public class FontDemo {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
