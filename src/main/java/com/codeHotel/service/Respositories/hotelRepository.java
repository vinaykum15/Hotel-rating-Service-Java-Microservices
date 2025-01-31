package com.codeHotel.service.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeHotel.service.Entities.Hotel;

public interface hotelRepository extends JpaRepository<Hotel,String> {
	
	//

}
