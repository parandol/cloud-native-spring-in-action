package kr.ejsoft.lecture.chap10.orderservice.test;

import kr.ejsoft.lecture.chap10.orderservice.controller.OrderController;
import kr.ejsoft.lecture.chap10.orderservice.domain.Order;
import kr.ejsoft.lecture.chap10.orderservice.domain.OrderRequest;
import kr.ejsoft.lecture.chap10.orderservice.domain.OrderStatus;
import kr.ejsoft.lecture.chap10.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@WebFluxTest(OrderController.class)
public class OrderControllerWebFluxTests {
    @Autowired
    private WebTestClient webClient;

    @MockitoBean
    private OrderService orderService;

    @Test
    void whenNotAvailableThenRejectOrder() {
        var orderRequest = new OrderRequest("1234567890", 3);
        var expectedOrder = OrderService.buildRejectedOrder(orderRequest.isbn(), orderRequest.quantity());
        given(orderService.submitOrder(
                orderRequest.isbn(), orderRequest.quantity()
        ))
                .willReturn(Mono.just(expectedOrder));

        webClient
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
