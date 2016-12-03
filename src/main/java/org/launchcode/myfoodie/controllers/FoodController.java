package org.launchcode.myfoodie.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.myfoodie.models.Food;
import org.launchcode.myfoodie.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController extends AbstractController {
	
	// maps to homepage
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		
		return "index";
		
	}
	
	//maps to newfood entry page
	@RequestMapping(value = "/newfood", method = RequestMethod.GET)
	public String newfoodform(Model model){
		
		return "newfood";
		
	}
	@RequestMapping(value = "/newfood", method = RequestMethod.POST)
	public String newfood(HttpServletRequest request, Model model){
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
		if (price == ""){
			error = "How much did it cost you?";
			model.addAttribute("error", error);
			return "newfood";
		}
		if (rating == ""){
			error = "How would you rate this food?";
			model.addAttribute("error", error);
			return "newfood";
		}
		model.addAttribute("foodname", foodname);
		model.addAttribute("description", description);
		model.addAttribute("place", place);
		model.addAttribute("price", price);
		model.addAttribute("worthit", worthit);

		// if valid, create new Post
		Food food = new Food(foodname, place, description, price, rating, worthit);
		foodDao.save(food);
		String username = user.getUsername();
		int uid = food.getUid();
		
		return ("redirect:/" + username + "/"+ uid); //  - this redirect should go to the new post's page  				
	}
	
	//maps to myfood to list all of the user's reviewed foods.
	@RequestMapping(value = "/myfood", method = RequestMethod.GET)
	public String myfood(Model model){
		
		return "myfood";
		
	}
	

}
