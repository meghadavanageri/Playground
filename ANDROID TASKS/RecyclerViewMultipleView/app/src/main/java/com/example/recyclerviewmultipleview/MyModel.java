package com.example.recyclerviewmultipleview;

public class MyModel {
    private String title;
    private int type;

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;

    public MyModel(String title,int type) {
        this.title = title;
        this.type= type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
