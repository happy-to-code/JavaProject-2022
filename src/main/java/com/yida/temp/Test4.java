package com.yida.temp;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        var persons = new ArrayList<Person>(10);
        persons.add(new Person("xm", 2, 0));
        persons.add(new Person("xh", 12, 0));
        persons.add(new Person("zs", 5, 1));
        persons.add(new Person("aa", 15, 1));

        System.out.println("persons = " + persons);

        List<String> names = persons.stream().map(Person::getName).sorted().collect(Collectors.toList());
        System.out.println("names = " + names);
    }
}


