package fi.mediavustin.firststep;

import org.hibernate.criterion.Example;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/myerror")
    String stdErrorMsg() {
        return "This is my error message!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
