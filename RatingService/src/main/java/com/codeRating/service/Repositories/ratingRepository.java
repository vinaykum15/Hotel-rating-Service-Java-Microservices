package com.codeRating.service.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeRating.service.Entities.Rating;

public interface ratingRepository extends JpaRepository<Rating, String> {
	
	//custom finder methods
	
	List<Rating> findRatingByUserId(String userId);
	List<Rating> findRatingByHotelId(String hotelId);
	
	

}
