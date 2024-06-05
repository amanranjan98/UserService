package com.microservice.UserService.externalService;

import com.microservice.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingService {
    @GetMapping("/rating/users/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable int userId);
}
