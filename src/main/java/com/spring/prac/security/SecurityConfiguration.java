package com.spring.prac.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
    private static String REALM="MY_TEST_REALM";


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

        authenticationManagerBuilder.inMemoryAuthentication().withUser("akhi").password("akhi123").roles("ADMIN");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("kuku").password("kuku123").roles("USER");


    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("ADMIN")
                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return  new CustomBasicAuthenticationEntryPoint();
    }

    @Override
    public  void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
    }
}
