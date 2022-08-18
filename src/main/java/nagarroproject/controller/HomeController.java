package nagarroproject.controller;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import nagarroproject.SpringRestClient.RestServicesImpl;
import nagarroproject.dao.UserDao;
import nagarroproject.model.ResponseDto;
import nagarroproject.model.User;
import nagarroproject.model.UserSignInReq;


@Controller
public class HomeController {
	
	RestServicesImpl restServicesImpl=new RestServicesImpl();
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
	
	@RequestMapping("/test")
	public void test1() {
	restServicesImpl.signin("dkfsdfal@gmail.com", "12345678");
		
		
	}
	
	
	@PostMapping("/validation")
	public ModelAndView validationUser(@RequestParam("useremail") String uemail, @RequestParam("userpwd") String upwd) {
		
			ModelAndView modelAndView=new ModelAndView();
			
			String op=restServicesImpl.signin(uemail, upwd);
			
			modelAndView.addObject("output", op);
		
			modelAndView.setViewName("home");
			return modelAndView;
	}
	
	

	
}
