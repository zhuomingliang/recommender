package com.jusco.taste.jrs.model;

public class Product {
    public static final String ID = "id";
    public static final String TITLE = "title";

    private int id;
    private String title;

    public Product(){

    }

    public Product(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + title + "  ");
        return sb.toString();
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("{'id':" + id + ", ");
        sb.append("'name':'" + title + "', ");
        return sb.toString();
    }
}
