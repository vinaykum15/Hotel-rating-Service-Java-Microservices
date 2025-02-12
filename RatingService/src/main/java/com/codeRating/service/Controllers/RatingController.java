package com.codeRating.service.Controllers;

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

import com.codeRating.service.Entities.Rating;


@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private com.codeRating.service.Services.ratingService ratingService;
	
	//create
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	
	//getAll
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		
		List<Rating> allratings = ratingService.getRatings();
		return ResponseEntity.ok(allratings);
	}
	//getByUserId
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		List<Rating> RatingByUserId = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(RatingByUserId);
	}
	
	//getByhotelId
	@GetMapping("/hotels/hotelId")
public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		
	List<Rating> ratingByhotelId = ratingService.getRatingByHotelId(hotelId);
	
		return ResponseEntity.ok(ratingByhotelId);
	}
	
	
}
