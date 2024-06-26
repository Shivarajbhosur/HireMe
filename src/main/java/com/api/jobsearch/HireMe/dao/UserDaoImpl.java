package com.api.jobsearch.HireMe.dao;

import com.api.jobsearch.HireMe.entity.User;
import com.api.jobsearch.HireMe.response.Response;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;


    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getuserById(int id) {
        User getuser = entityManager.find(User.class, id);
        return getuser;
    }

    @Override
    public Response addNewUser(User newuser) {
        User theUser = entityManager.merge(newuser);
        Response response = new Response();
        if (theUser.getId() != 0) {
            response.setStatusCode(200);
            response.setMsg("SUCCESS");
        } else {
            response.setStatusCode(400);
            response.setMsg("FAILED");
        }
        return response;
    }


    //to check user is exist or not
    @Override
    public Response checkUser(User theUser) {
        String email = theUser.getEmail();
        String password = theUser.getPsw();
        // Query to check if the user exists with the given email and password
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email AND u.psw = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            User foundUser = query.getSingleResult();
            // User with the given email and password exists
            Response response = new Response();
            response.setStatusCode(200);
            response.setMsg("SUCCESS");
            return response;
        } catch (Exception e) {
            // User with the given email and password does not exist
            Response response = new Response();
            response.setStatusCode(404);
            response.setMsg("User not found");
            return response;
        }
    }
}
