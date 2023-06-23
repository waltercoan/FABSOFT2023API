package br.univille.projfabsoft2023api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends 
    WebSecurityConfigurerAdapter {

    @Autowired
    private JWTRequestFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests().antMatchers("/api/v1/auth/signin").permitAll()
        .antMatchers("/api/**").authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy((SessionCreationPolicy.STATELESS));
        


        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
    
}
