package com.api.jobsearch.HireMe.service;

import com.api.jobsearch.HireMe.dao.UserDao;
import com.api.jobsearch.HireMe.entity.User;
import com.api.jobsearch.HireMe.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@org.springframework.stereotype.Service
public class serviceImpl implements Service {

    private UserDao userDao;

    @Autowired
    public serviceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUserById(int id) {
        return userDao.getuserById(id);
    }

    @Override
    @Transactional
    public Response addNewUser(User newuser) {
        return userDao.addNewUser(newuser);
    }

    public Response checkUser(User theUser) {
        return userDao.checkUser(theUser);

    }
}