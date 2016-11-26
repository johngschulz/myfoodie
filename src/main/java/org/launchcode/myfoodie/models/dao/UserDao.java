package org.launchcode.myfoodie.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.myfoodie.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	User findByUid(int uid);
    User findByName(String name);
    List<User> findAll();
}
