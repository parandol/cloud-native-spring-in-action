package kr.ejsoft.lecture.chap12.orderservice.event;

public record OrderDispatchedMessage(
        Long orderId
) {
}
