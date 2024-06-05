package com.microservice.UserService.impl;

import com.microservice.UserService.Repository.UserRepo;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.externalService.RatingService;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    RatingService ratingService;

    @Mock
    UserRepo userRepo;

    private User user2;

    @BeforeEach
    void get(){
        MockitoAnnotations.initMocks(this);
    }
    @BeforeEach
    void get2(){
        user2 = new User();
        user2.setUserId(1);
        user2.setAge("24");
        user2.setName("Aman");
        user2.setPhoneNo("83737");
    }

    @Test
    void getUser() {
        when(userRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(new User(1, "2938", "12", "Aman")));
        User user = userService.getUser(101);
        Assertions.assertEquals(user,user2);
    }
}