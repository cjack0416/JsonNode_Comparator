package com.objectcompare;

import java.util.List;

public class NestedExample {

    private String str;
    private List<String> strings;

    public NestedExample(String str, List<String> strings) {
        this.str = str;
        this.strings = strings;
    }

    public String getStr() {
        return str;
    }

    public List<String> getStrings() {
        return strings;
    }
}
