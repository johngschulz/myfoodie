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

		// if valid, create new food
		Food food = new Food(user, foodname, place, description, price, rating, worthit);
		foodDao.save(food);
		String username = user.getUsername();
		int uid = food.getUid();
		
		return ("redirect:/" + username + "/"+ uid); //  - this redirect should go to the new food's page  				
	}

// The CSS won't work with the {uid} mapping
	@RequestMapping(value = "/{username}/{uid} ", method = RequestMethod.GET)
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

}

