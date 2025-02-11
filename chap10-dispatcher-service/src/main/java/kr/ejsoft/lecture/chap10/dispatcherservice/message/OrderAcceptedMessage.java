package kr.ejsoft.lecture.chap10.dispatcherservice.message;

public record OrderAcceptedMessage(
        Long orderId
) { }
