package com.soda_flavour.train.spring.relationship;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

public class RestMockJwtBuilder {

	public static RestMockJwtBuilder of(ApplicationContext context) {
		return new RestMockJwtBuilder();
	}
	
	private String name;
	private String[] roles = new String[] {};
	
	private RestMockJwtBuilder() {
	}
	public RestMockJwtBuilder name(String name) {
		this.name = name;
		return this;
	}
	public RestMockJwtBuilder roles(String... roles) {
		this.roles = roles;
		return this;
	}

	
	public Jwt jwt() {
		String id = UUID.randomUUID().toString();
		Jwt jwt = Jwt.withTokenValue(id).jti(name).header("name", name).subject(name).claim("authorities", Arrays.asList(roles)).build();
		return jwt;
	}

	public AbstractAuthenticationToken convert(Jwt jwt) {

		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

		JwtAuthenticationConverter c = new JwtAuthenticationConverter();
		c.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		
		AbstractAuthenticationToken t = c.convert(jwt);
		return t;
	}

	
	public Authentication build() {
		return convert(jwt());
	}

}
