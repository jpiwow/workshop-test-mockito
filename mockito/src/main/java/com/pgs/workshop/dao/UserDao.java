package com.pgs.workshop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pgs.workshop.domain.User;

@Repository
public class UserDao {
    
    public void create(User user) {
        //create user
    }
    
    public User read(Long id) {
        //read user
        User user = User.builder().id(id).firstName("Firstname").lastName("Lastname").build();
        return user;
    }
    
    public User update(User user) {
        return user;
    }
    
    public void delete(Long ig) {
        //delete user
    }
    
    public List<User> fetchAll() {
        return new ArrayList<User>();
    }
    
    public List<User> fetchAllForCompany(Long companyId) {
        return new ArrayList<User>();
    }
    
}
