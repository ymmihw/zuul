package com.ymmihw.spring.zuul;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@EnableWebSecurity
@Controller
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.csrf().disable();
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests =
        http.authorizeRequests();
    authorizeRequests.antMatchers("/mylogin", "/login").permitAll();
    authorizeRequests.antMatchers("/auth/login").permitAll();
    authorizeRequests.anyRequest().authenticated().and().formLogin().loginPage("/mylogin");
  }

  @GetMapping(path = {"/mylogin"})
  public String getlogin() {
    System.out.println("get login");
    return "forward:/auth/login";
  }

  @PostMapping(path = {"login"})
  public String postlogin() {
    System.out.println("post login");
    return "forward:/auth/login";
  }
}
