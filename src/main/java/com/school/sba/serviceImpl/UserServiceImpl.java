package com.school.sba.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.User;
import com.school.sba.repository.UserRepository;
import com.school.sba.requestDTO.UserRequest;
import com.school.sba.responseDTO.UserResponse;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest) {
		User user= userRepository.save(mapToUser(userRequest));
		ResponseStructure<UserResponse> responseStructure = new ResponseStructure<UserResponse>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved Successfully!!!");
		responseStructure.setData(mapToResponse(user));
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
	}
	private UserResponse mapToResponse(User user) {
		return UserResponse.builder().userId(user.getUserId())
				.userName(user.getUserName())
				.userEmail(user.getUserEmail())
				.userContactNo(user.getUserContactNo())
				.userReg(user.getUserReg())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.build();
	}
	private User mapToUser(UserRequest userRequest) {
		return User.builder().userName(userRequest.getUserName())
				.userContactNo(userRequest.getUserContactNo())
				.userEmail(userRequest.getUserEmail())
				.password(userRequest.getPassword())
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.userReg(userRequest.getUserReg())
				.build();
	}
}
