package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
@RequestMapping("/hello")
public class HomeController {

	@ResponseBody
	@GetMapping("/oi")
	public String home(HttpServletRequest request) {
		return "Olá pessoa autorizada na porta " + request.getServerPort();
	}

}
