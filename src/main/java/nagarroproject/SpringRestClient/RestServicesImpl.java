package nagarroproject.SpringRestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.Converter;

import nagarroproject.model.ResponseDto;

public class RestServicesImpl {

	 private static final String User_Signin="http://localhost:7800/user/signin";
	 private static final String User_Signup="http://localhost:7800/user/signup";
	 private static final String User_logout="http://localhost:7800/user/logout";
	
	 private static RestTemplate restTemplate = new RestTemplate();
	
	 public RestServicesImpl() {
			// Add the Jackson Message converter
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

			// Note: here we are making this converter to process any kind of response,
			// not only application/*json, which is the default behaviour
			converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
			restTemplate.getMessageConverters().add(converter);
		}
	
	 public String signin(String uemail, String upwd) {
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 
		 Map<String, String> req=new HashMap<String, String>();
		 req.put("email", uemail);
		 req.put("password", upwd);
		 
		 HttpEntity<Map<String, String>> request=new HttpEntity<Map<String,String>>(req,headers);
		
		 ResponseDto obj=restTemplate.postForObject(User_Signin, request, ResponseDto.class);

		
		 return obj.getStatus()+" "+obj.getMessage();
	 }
	 
	 
	 public String signup(String firstName,	String lastName,String email, String password, String confirmPassword) {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 
		 Map<String, String> req=new HashMap<String, String>();
		 req.put("firstName", firstName);
		 req.put("lastName", lastName);
		 req.put("email", email);
		 req.put("password", password);
		 req.put("confirmPassword", confirmPassword);
		 
		 
		 HttpEntity<Map<String, String>> request=new HttpEntity<Map<String,String>>(req,headers);
		 
		 ResponseDto obj=restTemplate.postForObject(User_Signup, request, ResponseDto.class);
		 
		 return obj.getStatus()+" "+obj.getMessage();
		 
	 }
	 
	
}
