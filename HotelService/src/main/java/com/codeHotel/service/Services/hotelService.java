package com.codeHotel.service.Services;

import java.util.List;

import com.codeHotel.service.Entities.Hotel;

public interface hotelService {
 
	
	// create 
	Hotel create(Hotel hotel);
	
	//getSingleHotel
	
	Hotel getHotelById(String hotelId);
	
	//getAll
	
	List<Hotel> getAll();
}
