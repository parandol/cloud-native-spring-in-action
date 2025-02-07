package kr.ejsoft.lecture.chap08.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Chap08OrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
