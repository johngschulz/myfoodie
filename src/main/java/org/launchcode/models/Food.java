package org.launchcode.models;

import java.io.File;

public class Food {

	private String foodname;
	private String place;
	private String description;
	private double cost;
	private int rating;
	private boolean worthit;
	private File picture;
	
	public Food(){};
	
	public Food(String foodname, String place, String description, double cost, int rating, boolean worthit){
		this.foodname = foodname;
		this.place = place;
		this.description = description;
		this.cost = cost;
		this.rating = rating;
		this.worthit = worthit;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isWorthit() {
		return worthit;
	}

	public void setWorthit(boolean worthit) {
		this.worthit = worthit;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}
	
}
