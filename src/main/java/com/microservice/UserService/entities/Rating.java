package com.microservice.UserService.entities;

public class Rating {
    private int ratingId;
    private int rating;
    private String ratingInfo;
    private int userId;
    private int hotelId;
    private Hotel hotel;


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingInfo() {
        return ratingInfo;
    }

    public void setRatingInfo(String ratingInfo) {
        this.ratingInfo = ratingInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
