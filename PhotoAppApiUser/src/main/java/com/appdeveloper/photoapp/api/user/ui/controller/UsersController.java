package com.appdeveloper.photoapp.api.user.ui.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloper.photoapp.api.user.service.UserService;
import com.appdeveloper.photoapp.api.user.shared.UserDto;
import com.appdeveloper.photoapp.api.user.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private Environment env;
	@Autowired
	UserService usersService;

	@GetMapping("/status/check")
	public String status() {
		return "working on port " + env.getProperty("local.server.port");
	}

	// add a post request to add the user
	@PostMapping
	public String createUser(@RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		usersService.createUser(userDto);
		
		return "Addinng new User";
	}
}
