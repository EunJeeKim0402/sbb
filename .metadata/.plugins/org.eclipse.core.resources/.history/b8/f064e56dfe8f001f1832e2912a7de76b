package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "ㅎㅇsbb";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public String login() {
	    return "main";
	}
}
