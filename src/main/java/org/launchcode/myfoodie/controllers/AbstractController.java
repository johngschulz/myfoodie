package org.launchcode.myfoodie.controllers;

import javax.servlet.http.HttpSession;

import org.launchcode.myfoodie.models.User;
import org.launchcode.myfoodie.models.dao.FoodDao;
import org.launchcode.myfoodie.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

// Uses Daos to set and get users from the session

public abstract class AbstractController {

	@Autowired
    protected UserDao userDao;
	
	@Autowired
	protected FoodDao foodDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
	
}