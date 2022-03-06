package com.yida.temp;


import java.util.Random;

public class Test6 {
    public static void main(String[] args) {

        new Random().ints(0, 100)   //生成0到100的随机数
                .distinct()   //去除重复的值
                .limit(50)    //只取前50个数
                .forEach(System.out::println);   //对每个元素调用println函数
    }
}


