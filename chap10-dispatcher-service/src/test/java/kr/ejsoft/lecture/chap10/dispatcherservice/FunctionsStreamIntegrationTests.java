package kr.ejsoft.lecture.chap10.dispatcherservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ejsoft.lecture.chap10.dispatcherservice.message.OrderAcceptedMessage;
import kr.ejsoft.lecture.chap10.dispatcherservice.message.OrderDispatchedMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
public class FunctionsStreamIntegrationTests {
    @Autowired
    private InputDestination input;

    @Autowired
    private OutputDestination output;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenOrderAcceptedThenDispatched() throws IOException {
        long orderId = 1212;
        Message<OrderAcceptedMessage> inputMessage = MessageBuilder.withPayload(new OrderAcceptedMessage(orderId)).build();
        Message<OrderDispatchedMessage> expectedOuputMessage = MessageBuilder.withPayload(new OrderDispatchedMessage(orderId)).build();

        this.input.send(inputMessage);
        assertThat(objectMapper.readValue(output.receive().getPayload(), OrderDispatchedMessage.class))
                .isEqualTo(expectedOuputMessage.getPayload());
    }
}
