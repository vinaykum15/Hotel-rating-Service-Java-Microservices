package com.codeHotel.service.Services.Impl;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeHotel.service.Entities.Hotel;
import com.codeHotel.service.Respositories.hotelRepository;
import com.codeHotel.service.Services.hotelService;
import com.codeHotel.service.exceptions.ResourceNotFoundException;

@Service
public class hotelServiceImpl implements  hotelService {

	@Autowired
	private hotelRepository hotelRepository;
	
	private Logger logger = LoggerFactory.getLogger(hotelService.class);
	
	@Override
	public Hotel create(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		 
		logger.info("Fetching hotel with ID: {}", hotelId);
		
		Hotel hotel =  hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Resource Not found on server!!"));
		
		return hotel;
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

}
