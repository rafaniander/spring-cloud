package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore())
					.resourceId("resources")
					.resourceId("hello");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/**").and().authorizeRequests().anyRequest().authenticated()
        .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
        .antMatchers(HttpMethod.OPTIONS, "/**").access("#oauth2.hasScope('read')")
        .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')");
	}

	@Bean
	public InMemoryTokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

}
