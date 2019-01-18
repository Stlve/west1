package com.example.a26740.west;

public class Book {
    public static final int TYPE_RECEIVED =0;
    public static final int TYPE_SENT =1;
    private String name;
    public Book(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }


}
