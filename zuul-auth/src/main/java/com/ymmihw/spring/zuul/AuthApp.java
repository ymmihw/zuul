package com.ymmihw.spring.zuul;

import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AuthApp {
  public static void main(String[] args) {
    SpringApplication.run(AuthApp.class, args);
  }



  @GetMapping("/a")
  public String a(Principal p) {
    if (p == null) {
      return "null";
    }
    return p.toString();
  }
}
