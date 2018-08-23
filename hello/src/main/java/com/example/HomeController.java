package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/home")
public class HomeController {

	@ResponseBody
	@GetMapping("/oi")
	public String home(HttpServletRequest request) {
		return "Olá pessoa autorizada na porta " + request.getServerPort();
	}

}
