package kr.ejsoft.lecture.chap12.orderservice.test;

import kr.ejsoft.lecture.chap12.orderservice.config.SecurityConfigure;
import kr.ejsoft.lecture.chap12.orderservice.controller.OrderController;
import kr.ejsoft.lecture.chap12.orderservice.domain.Order;
import kr.ejsoft.lecture.chap12.orderservice.domain.OrderRequest;
import kr.ejsoft.lecture.chap12.orderservice.domain.OrderStatus;
import kr.ejsoft.lecture.chap12.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@WebFluxTest(OrderController.class)
@Import(SecurityConfigure.class)
public class OrderControllerWebFluxTests {
    @Autowired
    private WebTestClient webClient;

    @MockitoBean
    private OrderService orderService;

    @MockitoBean
    ReactiveJwtDecoder reactiveJwtDecoder;

    @Test
    void whenNotAvailableThenRejectOrder() {
        var orderRequest = new OrderRequest("1234567890", 3);
        var expectedOrder = OrderService.buildRejectedOrder(orderRequest.isbn(), orderRequest.quantity());
        given(orderService.submitOrder(
                orderRequest.isbn(), orderRequest.quantity()
        ))
                .willReturn(Mono.just(expectedOrder));

        webClient
                .mutateWith(
                        SecurityMockServerConfigurers
                                .mockJwt()
                                .authorities(new SimpleGrantedAuthority("ROLE_customer"))
                )
                .post()
                .uri("/orders")
                .bodyValue(orderRequest)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Order.class).value(
                        actualOrder -> {
                            assertThat(actualOrder).isNotNull();
                            assertThat(actualOrder.status()).isEqualTo(OrderStatus.REJECTED);
                        }
                );
    }
}
