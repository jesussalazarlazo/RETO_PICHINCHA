package com.reactor.challenge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.reactor.challenge.app.jwt.config.AppConfiguration;
import com.reactor.challenge.app.jwt.config.WebSecurityConfig;

//@Import({ AppConfiguration.class, WebSecurityConfig.class })

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }


}
