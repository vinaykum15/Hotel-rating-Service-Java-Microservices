package com.codeuser.service.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Rating {

	private String ratingId;
	private String userid;
	private String hotelId;
	private int ratings;
	private String feedback;
	
	private Hotel hotel;
}
