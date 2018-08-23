package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
//	@Value("${security.oauth2.client.client-id}")
//	private String clientId;
//	
//	@Value("${security.oauth2.client.client-secret}")
//	private String secret; 
//	
//	@Value("${security.oauth2.client.scope}")
//    private String[] scopes;
//	
//    @Value("${security.oauth2.client.resource-ids}")
//    private String resourceIds;
//    
//    @Value("${security.oauth2.client.authorized-grant-types}")
//    private String[] authorizedGrantTypes;
//    
//    @Value("${security.oauth2.client.access-token-validity-seconds}")
//    private Integer accessTokenValiditySeconds;
//    
//    @Value("${security.oauth2.client.refresh-token-validity-seconds}")
//    private Integer refreshTokenValiditySeconds;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(this.authenticationManager);
	}
	
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		System.out.println("Client Id --------------->" + clientId);
//		System.out.println("Client Secret ----------->" + secret);
//		System.out.println("Scopes ------------------>" + scopes);
//		System.out.println("Resources Ids------------>" + resourceIds);
//		System.out.println("Authorized -------------->" + authorizedGrantTypes);
//		System.out.println("Access Token ------------>" + accessTokenValiditySeconds);
//		System.out.println("Refresh Token ----------->" + refreshTokenValiditySeconds);
//		
//		clients.inMemory()
//		.withClient("hello-example")
//		.secret("{noop}hello-example")
//		.scopes("read", "write")
//		.resourceIds("resources", "hello", "auth")
//		.authorizedGrantTypes("password", "refresh_token")
//		.accessTokenValiditySeconds(1800)
//		.refreshTokenValiditySeconds(20000);
//		
//		/*clients.inMemory()
//				.withClient(clientId)
//				.secret("{noop}"+secret)
//				.scopes(scopes)
//				.resourceIds(resourceIds)
//				.authorizedGrantTypes(authorizedGrantTypes)
//				.accessTokenValiditySeconds(accessTokenValiditySeconds)
//				.refreshTokenValiditySeconds(refreshTokenValiditySeconds);*/
//	}

	@Bean
	public InMemoryTokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(tokenStore());
		return tokenServices;
	}

}
