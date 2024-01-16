package com.school.sba.requestDTO;

import org.springframework.stereotype.Component;


//import com.school.sba.entity.School;
import com.school.sba.enam.UserRegistration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int userContactNo;
	private String userEmail;
	private  UserRegistration userReg;
//	private School school;
}
