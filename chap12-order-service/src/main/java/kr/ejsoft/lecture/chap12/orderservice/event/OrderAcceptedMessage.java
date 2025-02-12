package kr.ejsoft.lecture.chap12.orderservice.event;

public record OrderAcceptedMessage(
        Long orderId
) { }
