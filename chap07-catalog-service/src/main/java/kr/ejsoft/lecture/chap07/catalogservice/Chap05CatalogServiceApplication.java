package kr.ejsoft.lecture.chap07.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Chap05CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap05CatalogServiceApplication.class, args);
    }

}
