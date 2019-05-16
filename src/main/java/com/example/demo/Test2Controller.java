package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller {
	
	@RequestMapping("/jsp")
	String jsp(Model model) {

		return "test";
	}
	
}
