package org.launchcode.myfoodie.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.launchcode.myfoodie.models.User;


@Entity
@Table(name = "food")
public class Food extends AbstractEntity{
	
	private User foodie;
	private String foodname;
	private String place;
	private String description;
	private String price;
	private String rating;
	private String worthit;
	private Date eatenon;

	

	public Food(){};
	
	public Food(User foodie, String foodname, String place, String description, String price, String rating, String worthit){
		super ();
		this.foodie = foodie;
		this.foodname = foodname;
		this.place = place;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.worthit = worthit;
		this.eatenon = new Date();
		
		foodie.addFood(this);
	}
	@ManyToOne
	public User getFoodie() {
		return foodie;
	}
	@SuppressWarnings("unused")
	private void setfoodie(User foodie) {
		this.foodie = foodie;
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
	public String getWorthit() {
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
