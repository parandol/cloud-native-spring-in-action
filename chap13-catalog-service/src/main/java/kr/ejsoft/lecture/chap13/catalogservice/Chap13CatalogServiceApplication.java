package kr.ejsoft.lecture.chap13.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap13CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap13CatalogServiceApplication.class, args);
    }

}
