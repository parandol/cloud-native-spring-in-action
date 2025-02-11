package kr.ejsoft.lecture.chap10.orderservice.repository;

import kr.ejsoft.lecture.chap10.orderservice.domain.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
