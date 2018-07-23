package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "Olá, você está conectado!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login() {
		System.out.println("Logou!!!");
	}
}
