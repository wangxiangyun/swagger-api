package com.xlinyu.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.ApiOperation;
import com.xlinyu.user.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户列表", httpMethod = "GET", response = List.class, notes = "用户列表")
	public List<User> list(){
		
		List<User> users = new ArrayList<User>();
		
		User user1 = new User();
		user1.setUsername("张三");
		user1.setPassword("abc123");
		users.add(user1);
		
		
		return users;
	}
}
