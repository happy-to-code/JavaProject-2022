package com.yida.temp;


import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of("hello", "world1")
                .map(x -> x.length());
        System.out.println("integerStream = " + integerStream);
        integerStream.forEach(System.out::println);
    }
}


