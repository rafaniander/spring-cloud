package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableResourceServer
@Controller
@RefreshScope
@EnableAutoConfiguration
@RequestMapping("/")
public class HomeController {

	@Autowired
	private HomePropertie propertie;

	@ResponseBody
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		return "Olá " + propertie.getNome() + " na porta " + request.getServerPort();
	}

}
