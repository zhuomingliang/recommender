package com.jusco.taste.jrs.model;

public class User {
    private int id;
    private String name;

    public User(){

    }


    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("{'id':'" + id + "', ");
        sb.append("'name':'" + name + "', ");
        return sb.toString();
    }
}
