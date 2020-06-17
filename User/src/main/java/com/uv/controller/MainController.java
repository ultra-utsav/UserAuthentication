package com.uv.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uv.interfaces.UserRepository;
import com.uv.model.User;

@Controller
public class MainController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public String getHome()
	{
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String getLogin(HttpServletRequest req,Model model)
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Optional<User> user = userRepository.findById(username);
		
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			model.addAttribute("user", username);
			return "profile";
		}else {
			model.addAttribute("message", "Invalid!! credintial");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/user/{username}")
	@ResponseBody
	public Optional<User> getUser(@PathVariable("username")String username){
		Optional<User> user  = userRepository.findById(username);
		if(user.isPresent())
			return user;
		else
			return null;
	}
}
