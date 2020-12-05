package com.upgrad.quora.api.controller;
  
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.quora.api.model.SignupUserRequest;
import com.upgrad.quora.api.model.SignupUserResponse;
import com.upgrad.quora.service.business.SignupBusinessService;
import com.upgrad.quora.service.entity.UserEntity;

@RestController
@RequestMapping("/")

public class UserController {
  
@Autowired SignupBusinessService signupBusinessService;
	
  @RequestMapping(method= RequestMethod.POST, path="/signup", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<SignupUserResponse> signup(final SignupUserRequest signupUserRequest)
  {
	  final UserEntity userEntity = new UserEntity();
	  userEntity.setUuid(UUID.randomUUID().toString());
	  userEntity.setFirstName(signupUserRequest.getFirstName());
	  userEntity.setLastName(signupUserRequest.getLastName());
      userEntity.setEmail(signupUserRequest.getEmailAddress());
      userEntity.setPassword(signupUserRequest.getPassword());
      userEntity.setMobilePhone(signupUserRequest.getContactNumber());
      userEntity.setSalt("1234abc");
    
      userEntity.setUserName(signupUserRequest.getUserName());
      userEntity.setCountry(signupUserRequest.getCountry());
      userEntity.setDob(signupUserRequest.getDob());
      userEntity.setAboutme(signupUserRequest.getAboutMe());
      
      final UserEntity createdUserEntity = signupBusinessService.signup(userEntity);
      SignupUserResponse userResponse = new SignupUserResponse().id(createdUserEntity.getUuid()).status("REGISTERED");
      return new ResponseEntity<SignupUserResponse>(userResponse,HttpStatus.CREATED);
  }
  
}
 