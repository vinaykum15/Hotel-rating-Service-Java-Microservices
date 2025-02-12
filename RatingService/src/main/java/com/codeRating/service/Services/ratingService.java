package com.codeRating.service.Services;

import java.util.List;

import com.codeRating.service.Entities.Rating;

public interface ratingService {

	//create
	
	Rating create(Rating rating);
	
	//getallrating
	
	List<Rating> getRatings();
	
	//get rating by userid
	
	List<Rating> getRatingByUserId(String userId);
	
	//get rating by hotelid
	
	List<Rating> getRatingByHotelId(String hotelId);
}
