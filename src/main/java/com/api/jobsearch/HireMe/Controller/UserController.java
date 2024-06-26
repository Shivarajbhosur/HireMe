package com.api.jobsearch.HireMe.Controller;


import com.api.jobsearch.HireMe.entity.User;
import com.api.jobsearch.HireMe.response.Response;
import com.api.jobsearch.HireMe.service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/HireMe")
public class UserController {

    private Service service;
    public UserController(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home()
    {

        return "Welcome to home";
    }
    @GetMapping("/test")
    public String testServerUp() {
    	System.out.println("Inside test method");
    	return "server Up and working";
    }


    @GetMapping("/getUserInfoById/{userid}")
    public User getUserById(@PathVariable int userid)
    {

        return service.getUserById(userid);
    }


    @PutMapping("/updateUser")
    public Response updateUser(@RequestBody User theNewUser)
    {
        return service.addNewUser(theNewUser);
    }
    //

    //create new user or register
    @PostMapping("/newUser")
    public Response addNewUserToApplication(@RequestBody User theNewUser){
        theNewUser.setId(0);
        return service.addNewUser(theNewUser);
    }
    //login usrer validatioon check exist or not
    @PostMapping("/loginUser")
    public Response loginUserValidation(@RequestBody User theNewUser){
        return service.checkUser(theNewUser);
    }
}
