package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {

	@ResponseBody
	@GetMapping("/user")
	public String user() {
		return "Olá, você está conectado!";
	}

	@PostMapping("/login")
	public void login() {
		System.out.println("Logou!!!");
	}
}
