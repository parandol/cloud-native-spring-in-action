package kr.ejsoft.lecture.chap10.orderservice.event;

public record OrderDispatchedMessage(
        Long orderId
) {
}
