package com.yida.temp;


import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        Integer x = 9;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(x);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(7);
        // treeSet.add(10);
        System.out.println("treeSet = " + treeSet);
        Integer lower = treeSet.lower(x);
        Integer higher = treeSet.higher(x);
        System.out.println("lower = " + lower);
        System.out.println("higher = " + higher);
    }
}


