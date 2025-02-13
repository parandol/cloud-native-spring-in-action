package kr.ejsoft.lecture.chap12.orderservice.repository;

import kr.ejsoft.lecture.chap12.orderservice.domain.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findAllByCreatedBy(String userId);
}
