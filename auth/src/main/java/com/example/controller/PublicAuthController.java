package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicAuthController {
	
	@ResponseBody
	@GetMapping("/mensagem")
	public String mensagem() {
		return "Essa mensagem é publica";
	}

}
