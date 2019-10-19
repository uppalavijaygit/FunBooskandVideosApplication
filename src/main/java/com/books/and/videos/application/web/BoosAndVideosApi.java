package com.books.and.videos.application.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class BoosAndVideosApi {
	
	@GetMapping("/hello")
	public String helloMsg() {
		return "Hellow";
	}
	
	

}
