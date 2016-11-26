package org.launchcode.myfoodie.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user")
public class User extends AbstractEntity {
	
	private String name;
	private String pwHash;
	private List<Food> foods;
	
	public User(){};
	public User(String name, String password){
		super();
		this.name = name;
		this.pwHash = hashPassword(password);
	}
	@NotNull
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull
    @Column(name="pwhash")
	public String getPwHash() {
		return pwHash;
	}
	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}
	protected void addFood(Food food){
		foods.add(food);
	}
	@OneToMany
    @JoinColumn(name = "foodie_uid")
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
