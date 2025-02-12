package kr.ejsoft.lecture.chap12.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Chap12OrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
