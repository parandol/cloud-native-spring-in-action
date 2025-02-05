package kr.ejsoft.lecture.chap04.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Chap04ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap04ConfigServiceApplication.class, args);
    }

}
