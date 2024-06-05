package com.microservice.UserService.impl;


import com.microservice.UserService.Repository.UserRepo;
import com.microservice.UserService.entities.Hotel;
import com.microservice.UserService.entities.Rating;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exceptions.ResourceNotFoundException;
import com.microservice.UserService.externalService.HotelService;
import com.microservice.UserService.externalService.RatingService;
import com.microservice.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;


    @Autowired
    RestTemplate restTemplate;
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User addUser(User user) {
        User save = userRepo.save(user);
        return save;
    }

    @Override
    public User getUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
//        List<Rating> ratingByUserId = this.restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), List.class);
//        System.out.println(ratingByUserId);

        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);

//        Arrays.stream(ratingByUserId).toList();
//        logger.info("{}",ratingByUserId);

//        List<Rating> ratingList = ratingByUserId.stream().map(rating -> {
//            Hotel ratingByHotelId = this.restTemplate.getForObject("http://localhost:8082/rating/hotel/" + rating.getHotelId(), Hotel.class);
//            rating.setHotel(ratingByHotelId);
//            return rating;
//        }).collect(Collectors.toList());

//        List<Rating> ratingList = ratingByUserId.stream().map(rating -> {
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            rating.setHotel(hotel);
//            return rating;
//        }).collect(Collectors.toList());
//        for (Rating rating:ratingByUserId){
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            rating.setHotel(hotel);
//        }

        user.setRating(ratingByUserId);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User deleteUser(int userId) {

        User deletedUser = userRepo.findById(userId).get();
        userRepo.deleteById(userId);
        return deletedUser;
    }


}
