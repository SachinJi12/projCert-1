package com.appdeveloper.photoapp.api.user.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloper.photoapp.api.user.data.UserEntity;
import com.appdeveloper.photoapp.api.user.data.UsersRepository;
import com.appdeveloper.photoapp.api.user.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UsersRepository usersRepository;
	
	public UserServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		usersRepository.save(userEntity);
		return null;
	}

}
