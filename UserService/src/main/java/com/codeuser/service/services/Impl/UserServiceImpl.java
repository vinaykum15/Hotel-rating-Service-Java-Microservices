package com.codeuser.service.services.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codeuser.service.Entities.Hotel;
import com.codeuser.service.Entities.Rating;
import com.codeuser.service.Entities.User;
import com.codeuser.service.exceptions.ResourceNotFoundException;
import com.codeuser.service.repositories.UserRepository;
import com.codeuser.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
   
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	
	@Override
	public User saveUser(User user) {
		
		String randomUserId = UUID.randomUUID().toString();
		
		user.setUserId(randomUserId);
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		// we can implement rating service call using rest template for getting ratings when calling getAllUsers
		return userRepository.findAll();
	}

	@Override
	public User getSinlgeUser(String userId) {
		
		User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource Not found on server!!"));
		
		//get ratings from rating services for the above user with given userid
		// we can make localhost:8073 part as dynmic too because service my be hosted on any other port or ip or server
		                                                   // we need to remove host and port and make it dynamic 
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);//on run user service give class cast ecxaption for LinkedHash cant convert so we change arraylist.class to proper rating[] array rating
	   //this rating[] array class can eb change to aaraylist as below
		
		logger.info("{}", ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
	   
	   List<Rating> ratingList = ratings.stream().map(rating -> {
		   
		   
		   //http://localhost:8072/hotels/39e3508d-e632-4f7a-b30a-94b3ffe7ad05
		ResponseEntity<Hotel>   forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);   //api call to hotel service to get the hotel
		   
		Hotel hotel = forEntity.getBody();// we could have used getforObject but to learn more about http and entity we user getforEntity for getting more info, like we can use logger.info here 
		//and get more info , for ex print the status code foraEntity.getStatusCode so, http ke more info ke liye we use getforentity
		logger.info("response status code:{}",forEntity.getStatusCode() );
		// we have get hotel above and now (us rating ke andar hotel ko set krenege) we can set the hotel to rating
		rating.setHotel(hotel);
		   //return the rating
		   
		   return rating;
	   }).collect(Collectors.toList());
	   
	   //before setting user.setRatings we need to set har ek rating ke pass ek hotel set krna hoga , now we can go to rating entity in userseervuce and declare private hotel hotel
	   //and create a class hotel within user service along with hotel detail or dataa from hotel entity and is class ki reference rating class in usersevice ke pass hand then getter and setter nd all and no @entity there
	   //hum rating class me hotel class banaye(kis hotel ki kya rating) wese hum ulta bhi kr skte the, user ne kis hotel ko rate kia aap ye bhi nikal skte the by declaring hotel class in user entity itslef
	   //abhi tak hum kis user ki kya rating h paa rhe h, but wo rating kis hotel ki h ye nhi mil rha tha. and ab hum rating.stream.map krke har rating ka detail list nikal rhe with hotel look above
	   user.setRatings(ratingList);		
	   return user;
	}
	
	

}
