package com.objectcompare;

import java.util.List;

public class Example {

    private int num;
    private List<Integer> list;
    private NestedExample nestedExample;

    public Example(int num, List<Integer> list, NestedExample nestedExample) {
        this.num = num;
        this.list = list;
        this.nestedExample = nestedExample;
    }

    public int getNum() {
        return num;
    }

    public NestedExample getNestedExample() {
        return nestedExample;
    }

    public List<Integer> getList() {
        return list;
    }
}
