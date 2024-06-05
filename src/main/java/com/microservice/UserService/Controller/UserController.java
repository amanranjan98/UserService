package com.microservice.UserService.Controller;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

//    int retry=1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelServiceRetry",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "UserServiceRateLimiter",fallbackMethod = "ratingHotelFallback")
    public User getUser(@PathVariable int userId){
//        logger.info("retry count is "+retry);
//        retry++;
        return userService.getUser(userId);
    }

    public User ratingHotelFallback(int userId,Exception ex){
        logger.info("Fallback executed server is down",ex.getMessage());
        User user = new User();
        user.setName("Dummy");
        user.setAge("");
        user.setPhoneNo("");
        user.setUserId(123);
        return user;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
}
