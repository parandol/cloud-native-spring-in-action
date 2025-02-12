package kr.ejsoft.lecture.chap12.orderservice.service;

import kr.ejsoft.lecture.chap12.orderservice.client.BookClient;
import kr.ejsoft.lecture.chap12.orderservice.domain.Book;
import kr.ejsoft.lecture.chap12.orderservice.domain.Order;
import kr.ejsoft.lecture.chap12.orderservice.domain.OrderStatus;
import kr.ejsoft.lecture.chap12.orderservice.event.OrderAcceptedMessage;
import kr.ejsoft.lecture.chap12.orderservice.event.OrderDispatchedMessage;
import kr.ejsoft.lecture.chap12.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final BookClient bookClient;
    private final OrderRepository orderRepository;
    private final StreamBridge streamBridge;

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> submitOrder(String isbn, int quantity) {
//        return Mono.just(buildRejectedOrder(isbn, quantity))
//                .flatMap(orderRepository::save);

        return bookClient.getBookByIsbn(isbn)
                .map(book -> buildAcceptedOrder(book, quantity))
                .defaultIfEmpty(
                        buildRejectedOrder(isbn, quantity)
                )
                .flatMap(orderRepository::save);
    }

    public static Order buildAcceptedOrder(Book book, int quantity) {
        return Order.of(
                book.isbn(),
                book.title() + "-" + book.author(),
                book.price(),
                quantity,
                OrderStatus.ACCEPTED
        );
    }

    public static Order buildRejectedOrder(String isbn, int quantity) {
        return Order.of(isbn, null, null, quantity, OrderStatus.REJECTED);
    }

    public Flux<Order> consumeOrderDispatchedEvent(Flux<OrderDispatchedMessage> flux) {
        return flux.flatMap(message -> orderRepository.findById(message.orderId()))
                .map(this::buildDispatchedOrder)
                .flatMap(orderRepository::save)
                .doOnNext(this::publishOrderAcceptedEvent);
    }

    private Order buildDispatchedOrder(Order existingOrder) {
        return new Order(
                existingOrder.id(),
                existingOrder.bookIsbn(),
                existingOrder.bookName(),
                existingOrder.bookPrice(),
                existingOrder.quantity(),
                OrderStatus.DISPATCHED,
                existingOrder.createdAt(),
                existingOrder.lastModifiedAt(),
                existingOrder.version()
        );
    }

    private void publishOrderAcceptedEvent(Order order) {
        if(!order.status().equals(OrderStatus.ACCEPTED)) {
            return;
        }

        var orderAcceptedMessage = new OrderAcceptedMessage(order.id());
        log.info("Sending order accepted event with id: {}", order.id());

        var result = streamBridge.send("acceptOrder-out-0", orderAcceptedMessage);
        log.info("Result of sending data for order with id {}: {}", order.id(), result);
    }
}
