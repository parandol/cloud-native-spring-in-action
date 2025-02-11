package kr.ejsoft.lecture.chap10.orderservice.controller;

import jakarta.validation.Valid;
import kr.ejsoft.lecture.chap10.orderservice.domain.Order;
import kr.ejsoft.lecture.chap10.orderservice.domain.OrderRequest;
import kr.ejsoft.lecture.chap10.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.submitOrder(orderRequest.isbn(), orderRequest.quantity());
    }
}
