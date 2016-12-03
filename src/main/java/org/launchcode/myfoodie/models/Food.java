package org.launchcode.myfoodie.models;

import java.util.Date;

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
	private String price;
	private String rating;
	private String worthit;
	private Date eatenon;

	

	public Food(){};
	
	public Food(String foodname, String place, String description, String price, String rating, String worthit){
		super ();
		this.foodname = foodname;
		this.place = place;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.worthit = worthit;
		this.eatenon = new Date();
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
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@NotNull
    @Column(name = "rating")
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	@NotNull
    @Column(name = "worthit")
	public String isWorthit() {
		return worthit;
	}

	public void setWorthit(String worthit) {
		this.worthit = worthit;
	}
	@NotNull
	@Column(name = "eatenon")
	public Date getEatenon(){
		return eatenon;
	}
	public void setEatenon(Date eatenon) {
		this.eatenon = eatenon;
	}
}
