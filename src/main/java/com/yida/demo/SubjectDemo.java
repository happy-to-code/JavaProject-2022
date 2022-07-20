package com.yida.demo;

import com.yida.model.CategoryModel;

public class SubjectDemo {
    public static void main(String[] args) {
        CategoryModel cm = new CategoryModel();
        cm.setId(1L);
        cm.setName("test");
        cm.setLevel(0);

        System.out.println("cm = " + cm);
        System.out.println("=====================");
        CategoryModel cm2 = cm.changeName(cm);
        System.out.println("cm2 = " + cm2);

    }

    // public static CategoryModel changeName(CategoryModel cm){
    //     cm.setName(cm.getName()+"123");
    //     return cm;
    // }
}
