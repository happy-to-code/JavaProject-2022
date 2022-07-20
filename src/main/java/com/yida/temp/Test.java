package com.yida.temp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello world");
        List<String> arr = new ArrayList<>(10);
        arr.addAll(Arrays.asList("1", "aa"));
        System.out.println("arr = " + arr);
        // Object[] objects = arr.toArray(String[]::new);
        // System.out.println("objects = " + objects);
        // for (Object object : objects) {
        //     System.out.println(object);
        // }
    }
}


