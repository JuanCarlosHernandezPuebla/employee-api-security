package com.rest_api.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests(configure -> configure
               .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
               .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
               .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
               .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
               .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

       http.httpBasic(Customizer.withDefaults());

       http.csrf(csrf -> csrf.disable());

       return http.build();
    }

}
