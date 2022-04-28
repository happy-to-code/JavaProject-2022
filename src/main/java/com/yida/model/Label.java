package com.yida.model;

import lombok.Data;

import java.util.List;

@Data
public class Label {
    private String name;
    private String totalCount;
    private List<SubLabel> subLabelList;
}
