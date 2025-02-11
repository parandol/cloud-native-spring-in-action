package kr.ejsoft.lecture.chap10.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Chap10OrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
