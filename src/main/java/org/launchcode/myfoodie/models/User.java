package org.launchcode.myfoodie.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "user")
public class User extends AbstractEntity {
	
	private String username;
	private String pwHash;
	private List<Food> foods;
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public User(){};
	
	public User(String username, String password){
		super();
		if (!isValidUsername(username)) {
			throw new IllegalArgumentException("Invalid username");
		}
		
		this.username = username;
		this.pwHash = hashPassword(password);
	}
	

	@NotNull
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String name) {
		this.username = name;
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
	
	public boolean isMatchingPassword(String password) {
		return encoder.matches(password, pwHash);
	}
	
	public static boolean isValidPassword(String password) {
		Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
		Matcher matcher = validUsernamePattern.matcher(password);
		return matcher.matches();
	}
	
	public static boolean isValidUsername(String username) {
		Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		Matcher matcher = validUsernamePattern.matcher(username);
		return matcher.matches();
	}
	
	private static String hashPassword(String password) {		
		return encoder.encode(password);
	}
}
