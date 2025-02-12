package kr.ejsoft.lecture.chap12.orderservice.repository;

import kr.ejsoft.lecture.chap12.orderservice.domain.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
