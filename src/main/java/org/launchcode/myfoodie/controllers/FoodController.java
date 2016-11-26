package org.launchcode.myfoodie.controllers;

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
	public String newfood(Model model){
		
		return "newfood";
		
	}
	
	//maps to myfood to list all of the user's reviewed foods.
	@RequestMapping(value = "/myfood", method = RequestMethod.GET)
	public String myfood(Model model){
		
		return "myfood";
		
	}
	

}
