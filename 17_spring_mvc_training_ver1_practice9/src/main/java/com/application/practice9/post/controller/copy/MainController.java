package com.application.practice9.post.controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping
	public String main() {
		return "/post/postMain";
	}
	
}
