package kr.ejsoft.lecture.chap04.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap04CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap04CatalogServiceApplication.class, args);
    }

}
