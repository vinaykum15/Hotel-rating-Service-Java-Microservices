package com.codeHotel.service.Controller;
import com.codeHotel.service.Entities.Hotel;
import com.codeHotel.service.Services.hotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class hotelController {

	@Autowired
	private hotelService  hotelService;
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	//getSinlgehotel
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		
		
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
		
	}
	
	//getAll
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	
}
