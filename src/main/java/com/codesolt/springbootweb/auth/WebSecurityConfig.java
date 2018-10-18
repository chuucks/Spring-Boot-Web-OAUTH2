package com.codesolt.springbootweb.auth;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**")
            .authorizeRequests()            
            .antMatchers("/", "/index", "/login", "/webjars/**", "/error**")
            	.permitAll()
            .anyRequest()
            	.authenticated()
            .and().logout()
            	.logoutSuccessUrl("/index").permitAll()
        	.and()
        		.csrf()
        		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
