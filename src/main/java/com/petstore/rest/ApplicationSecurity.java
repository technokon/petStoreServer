package com.petstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iakoupov on 2016-11-27.
 */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER") // user
                .and()
                .withUser("admin").password("admin").roles("ADMIN"); // admin
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // disable csrf token
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/pet-store/**").authenticated()    // block post
                .antMatchers(HttpMethod.PUT, "/pet-store/**").authenticated()     // block put
                .antMatchers(HttpMethod.DELETE, "/pet-store/**").authenticated() // block delete
                .and()
                .logout().deleteCookies("JSESSIONID").permitAll(); // remove on logout
                //.and().headers().cacheControl().disable();        // allow cache

        // send 401 if blocked
        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        });

        // handle success
        http.formLogin().successHandler(new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {

                clearAuthenticationAttributes(request);
            }
        });

        // handle failure
        http.formLogin().failureHandler(new SimpleUrlAuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {

                super.onAuthenticationFailure(request, response, exception);
            }
        });

        http.logout().logoutSuccessUrl("/");

        // CSRF tokens handling
        //http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
    }
}