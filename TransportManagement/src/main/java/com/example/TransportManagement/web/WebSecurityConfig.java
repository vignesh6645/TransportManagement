package com.example.TransportManagement.web;

import com.example.TransportManagement.security.JwtAuthenticationEntryPoint;
import com.example.TransportManagement.security.JwtFilter;
import com.example.TransportManagement.servieceImplements.LoadServieceImplements;
import com.example.TransportManagement.servieceImplements.UserServieceImplements;
import com.example.TransportManagement.servieceImplements.VehicleServieceImplements;
import com.example.TransportManagement.servieceImplements.VehicleTypeServieceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServieceImplements userServiece;

    @Autowired
    private LoadServieceImplements loadServiece;

    @Autowired
    private VehicleServieceImplements vehicleServiece;

    @Autowired
    private VehicleTypeServieceImplements vehicleTypeServiece;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors();
        http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        http.authorizeRequests()
                .antMatchers("/user/create","/user/login")
                .permitAll().anyRequest().authenticated().and().formLogin().permitAll();

        http.addFilterBefore(jwtFilter(),UsernamePasswordAuthenticationFilter.class);


    }


}
