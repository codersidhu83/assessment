package nagarroproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nagarroproject.dao.UserDao;
import nagarroproject.model.User;


@Controller
public class HomeController {
	
	@Autowired
	UserDao UserDao;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/regform")
	public String test() {
		return "regform";
	}
	
	
	@PostMapping("/processform")
	public String getData(@ModelAttribute User user) {
		//System.out.println(user);
		UserDao.saveUser(user);
		return "home";
	}
	
	
	@PostMapping("/validation")
	public void validationUser(@RequestParam("useremail") String uemail, @RequestParam("userpwd") String upwd) {
			System.out.println(UserDao.findUser(uemail, upwd));
	}
	
	
	
	
	
}
