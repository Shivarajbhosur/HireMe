package com.api.jobsearch.HireMe.service;

import com.api.jobsearch.HireMe.entity.User;
import com.api.jobsearch.HireMe.response.Response;

public interface Service {

    User getUserById(int id);
    Response addNewUser(User newuser);


    Response checkUser(User theNewUser);
}
