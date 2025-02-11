package kr.ejsoft.lecture.chap10.orderservice.event;

public record OrderAcceptedMessage(
        Long orderId
) { }
