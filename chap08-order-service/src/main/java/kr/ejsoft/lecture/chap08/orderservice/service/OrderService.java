package kr.ejsoft.lecture.chap08.orderservice.service;

import kr.ejsoft.lecture.chap08.orderservice.client.BookClient;
import kr.ejsoft.lecture.chap08.orderservice.domain.Book;
import kr.ejsoft.lecture.chap08.orderservice.domain.Order;
import kr.ejsoft.lecture.chap08.orderservice.domain.OrderStatus;
import kr.ejsoft.lecture.chap08.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final BookClient bookClient;
    private final OrderRepository orderRepository;

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
}
