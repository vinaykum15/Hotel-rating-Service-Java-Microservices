package com.codeRating.service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_ratings")
public class Rating {

	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	private String ratings;
	private String feedback;
}
