package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("main.repositories")
public class SpringApp extends SpringBootServletInitializer {


    public static void main(String[] args) {

        SpringApplication.run(SpringApp.class, args);
    }

}
