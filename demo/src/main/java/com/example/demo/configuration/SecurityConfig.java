/*package com.example.demo.configuration;

import com.example.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityService securityService;

    @Autowired
    public SecurityConfig(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(securityService)
                .passwordEncoder(getPasswordEncoder());
    }


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, HTTP_FOR_TAG, HTTP_FOR_ORDERS, HTTP_FOR_GC).hasAnyAuthority(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.POST, HTTP_FOR_GC, HTTP_FOR_TAG).hasAnyAuthority(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HTTP_AUTH_LOGIN, HTTP_AUTH_REGISTRATION, HTTP_ERROR, HTTP_TOKEN)
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage(HTTP_AUTH_LOGIN)
                .loginProcessingUrl(HTTP_PROCESS_LOGIN)
                .failureUrl(HTTP_AUTH_LOGIN_ERROR)
                .and()
                .logout()
                .logoutUrl(HTTP_LOGOUT)
                .logoutSuccessUrl(HTTP_AUTH_LOGIN);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/

