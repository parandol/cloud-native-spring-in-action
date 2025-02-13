package kr.ejsoft.lecture.chap13.catalogservice.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix="polar")
public class PolarProperties {
    private String greeting;
}
