package org.launchcode.models;

import java.util.List;

public class User {
	
	private String name;
	private String pwHash;
	private List<Food> foods;
	
	public User(){};
	public User(String name, String password){
		this.name = name;
		this.pwHash = hashPassword(password);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwHash() {
		return pwHash;
	}
	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	//unfinished - must find a good way to implement hashing the password
	private String hashPassword(String password){
		return password;
	}
}
