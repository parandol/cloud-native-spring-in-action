package kr.ejsoft.lecture.chap12.orderservice.test;

import kr.ejsoft.lecture.chap12.orderservice.config.DatabaseConfigure;
import kr.ejsoft.lecture.chap12.orderservice.domain.OrderStatus;
import kr.ejsoft.lecture.chap12.orderservice.repository.OrderRepository;
import kr.ejsoft.lecture.chap12.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import reactor.test.StepVerifier;

import java.util.Objects;

@DataR2dbcTest
@Import(DatabaseConfigure.class)
@Testcontainers
public class OrderRepositoryR2dbcTests {
    @Container
    static PostgreSQLContainer<?> postgresql = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:14.4")
    );

    @Autowired
    private OrderRepository orderRepository;

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.r2dbc.url", OrderRepositoryR2dbcTests::r2dbcUrl);
        registry.add("spring.r2dbc.username", postgresql::getUsername);
        registry.add("spring.r2dbc.password", postgresql::getPassword);
        registry.add("spring.flyway.url", postgresql::getJdbcUrl);
    }

    private static String r2dbcUrl() {
        return String.format("r2dbc:postgresql://%s:%s/%s",
                postgresql.getContainerIpAddress(),
                postgresql.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT),
                postgresql.getDatabaseName()
        );
    }

    @Test
    void createRejectedOrder() {
        var rejectedOrder = OrderService.buildRejectedOrder("1234567890", 3);
        StepVerifier
                .create(orderRepository.save(rejectedOrder))
                .expectNextMatches(
                        order -> order.status().equals(OrderStatus.REJECTED)
                )
                .verifyComplete();
    }

    @Test
    void whenCreatedOrderNotAuthenticatedThenNoAuditMetadata() {
        var rejectedOrder = OrderService.buildRejectedOrder("1234567899", 3);
        StepVerifier.create(orderRepository.save(rejectedOrder))
                .expectNextMatches(order -> Objects.isNull(order.createdBy())
                        && Objects.isNull(order.lastModifiedBy()))
                .verifyComplete();
    }

    @Test
    @WithMockUser("marlena")
    void whenCreatedOrderAuthenticatedThenAuditMetadata() {
        var rejectedOrder = OrderService.buildRejectedOrder("1234567899", 3);
        StepVerifier.create(orderRepository.save(rejectedOrder))
                .expectNextMatches(order -> "marlena".equals(order.createdBy())
                        && "marlena".equals(order.lastModifiedBy()))
                .verifyComplete();
    }
}
