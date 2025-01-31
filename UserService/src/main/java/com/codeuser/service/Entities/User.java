package com.codeuser.service.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
	
	
	@Id
	@Column(name="ID")
	String userId;
	
	@Column(name ="NAME")
	String name;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="ABOUT")
	String about;
	
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
