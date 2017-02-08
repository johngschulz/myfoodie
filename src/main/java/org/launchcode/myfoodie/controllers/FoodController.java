package org.launchcode.myfoodie.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.myfoodie.models.Food;
import org.launchcode.myfoodie.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FoodController extends AbstractController {
	
	// maps to homepage
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
		List<Food>foods = foodDao.findAll();
		model.addAttribute("foods", foods);
		
		return "index";		
	}

	//maps to newfood entry page
	@RequestMapping(value = "/newfood", method = RequestMethod.GET)
	public String newFoodForm(Model model){

		return "newfood";
		
	}
	// Creates new food object if all data in form is valid
	@RequestMapping(value = "/newfood", method = RequestMethod.POST)
	public String newFood(HttpServletRequest request, Model model){
		String foodname = request.getParameter("foodname");
		String description = request.getParameter("description");
		String place = request.getParameter("place");
		String price = request.getParameter("price");
		String rating = request.getParameter("rating");
		String worthit = request.getParameter("worthit");
		String error = null;
		User user = getUserFromSession(request.getSession());
		
		// validate parameters
		// if not valid, send back to the form, with error message
		if (foodname == ""){
			error = "Please enter the food's name!";
			model.addAttribute("error", error);
			return "newfood";
		}
		if (description == ""){
			error = "Please add a description for the food!";
			model.addAttribute("error", error);
			return "newfood";
		}
		if (place == ""){
			error = "Please tell us where you ate this!";
			model.addAttribute("error", error);
			return "newfood";
		}
		if (price == "" ||	isNumeric(price) == false){
			error = "How much did it cost you?";
			model.addAttribute("error", error);
			return "newfood";
		}

		if (rating == "" || isNumeric(rating) == false || (Integer.parseInt(rating) <11 && Integer.parseInt(rating) > 0) == false){
			error = "How would you rate this food?";
			model.addAttribute("error", error);
			return "newfood";
		}
		// Attempting to format the price data to 2 decimals - may use javascript to format
		price = String.format("%.2f", Double.valueOf(price) + (double) 0.00000001);

		model.addAttribute("foodname", foodname);
		model.addAttribute("description", description);
		model.addAttribute("place", place);
		model.addAttribute("price", price);
		model.addAttribute("worthit", worthit);
		double newprice = Double.valueOf(price);

		

		// if valid, create new food
		Food food = new Food(user, foodname, place, description, newprice, rating, worthit);
		foodDao.save(food);
		String username = user.getUsername();
		int uid = food.getUid();
		
		return ("redirect:/" + username + "/f"+ uid); //  - this redirect should go to the new food's page  				
	}

	//Had issues with Spring finding path to static folder because {uid} was an int
	@RequestMapping(value = "/{username}/f{uid}", method = RequestMethod.GET)
	public String singleFood(@PathVariable String username, @PathVariable int uid, Model model) {
		
		//  - implement single food
		// get the given food
		Food food = foodDao.findByUid(uid);
		// pass the food into the template
		 
		model.addAttribute("food", food);

		return "singlefood";
	}

	
	//maps to myfood to list all of the user's reviewed foods.
	@RequestMapping(value = "/myfood", method = RequestMethod.GET)
	public String myFood(HttpServletRequest request, Model model){

		// get all of the user's foods List<list of food>
		
		User user = getUserFromSession(request.getSession());
		
		List<Food> foods = user.getFoods();
		// pass the posts into the template
		model.addAttribute("foods", foods);
			
		return "myfood";
		
	}
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String userPosts(@PathVariable String username, Model model) {
		
		//  - implement userPosts
		
		// get all of the user's posts List<listofpost>
		User user = userDao.findByUsername(username);

		List<Food> foods = user.getFoods();
		// pass the posts into the template
		model.addAttribute("foods", foods);
		
		return "myfood";
	}
	public static boolean isNumeric(String str)
	{
	  return str.matches("\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

}

