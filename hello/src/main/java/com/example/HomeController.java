package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
@EnableAutoConfiguration
@RequestMapping("/")
public class HomeController {
	
	@Value("${nome:Kratos}")
	private String nome;
	
	@ResponseBody
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		return "Olá " + nome + " na porta " + request.getServerPort(); 
	}

}
