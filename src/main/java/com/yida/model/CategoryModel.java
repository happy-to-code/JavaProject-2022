package com.yida.model;

import lombok.Data;

@Data
public class CategoryModel {

    private Long id;
    private Long parentId;
    private String name;
    private Integer level;



    public CategoryModel changeName(CategoryModel cm){
        cm.setName(cm.getName()+"123");
        return cm;
    }
}
