package com.jusco.taste.jrs.model;

public class User {
	public static final String ID = "id";
	public static final String NAME = "name";
	
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
		sb.append("{'" + ID + "':'" + id + "', ");
		sb.append("'" + NAME + "':'" + name + "', ");
		return sb.toString();
	}
}
