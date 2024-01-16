package com.school.sba.responseDTO;

import com.school.sba.enam.UserRegistration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private int userContactNo;
	private String userEmail;
	private  UserRegistration userReg;
//	private School school;
}
