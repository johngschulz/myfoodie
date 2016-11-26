package org.launchcode.myfoodie.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "food")
public class Food extends AbstractEntity{

	private String foodname;
	private String place;
	private String description;
	private double price;
	private int rating;
	private boolean worthit;

	
	public Food(){};
	
	public Food(String foodname, String place, String description, double price, int rating, boolean worthit){
		super ();
		this.foodname = foodname;
		this.place = place;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.worthit = worthit;
	}
	@NotNull
    @Column(name = "foodname")
	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	@NotNull
    @Column(name = "place")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	@NotNull
    @Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@NotNull
    @Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@NotNull
    @Column(name = "rating")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	@NotNull
    @Column(name = "worthit")
	public boolean isWorthit() {
		return worthit;
	}

	public void setWorthit(boolean worthit) {
		this.worthit = worthit;
	}
	
}
