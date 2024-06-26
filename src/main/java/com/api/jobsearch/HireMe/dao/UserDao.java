package com.api.jobsearch.HireMe.dao;

import com.api.jobsearch.HireMe.entity.User;
import com.api.jobsearch.HireMe.response.Response;

public interface UserDao {

    User getuserById(int id);

    Response addNewUser(User newuser);

    Response checkUser(User theUser);
}
