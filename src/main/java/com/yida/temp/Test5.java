package com.yida.temp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        System.out.println("list = " + list);
        list = list.stream().distinct().collect(toList());
        System.out.println("list = " + list);

        System.out.println("=====================");
        List<Integer> integers = Arrays.asList(1, 2, 2, 4, 5, 5, 1);
        long count = integers.stream().count();
        System.out.println("count = " + count);
        Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("reduce = " + reduce);

        var distinct = integers.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct = " + distinct);


    }
}


