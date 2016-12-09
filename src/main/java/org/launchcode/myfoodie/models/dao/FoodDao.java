package org.launchcode.myfoodie.models.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.myfoodie.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FoodDao extends CrudRepository<Food, Integer> {
	
	Food findByUid(int uid);
	Food findByFoodname(String foodname);
	List<Food> findAll();
	
}
