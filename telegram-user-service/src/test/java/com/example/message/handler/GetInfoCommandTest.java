package com.example.message.handler;

import com.example.commons.integratiom.test.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chat.Chat;
import org.telegram.telegrambots.meta.api.objects.message.Message;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
@TestPropertySource("classpath:integration-test.properties")
@AutoConfigureWireMock(port = 0, stubs = "classpath:/wiremock/stubs", files = "classpath:/wiremock")
public class GetInfoCommandTest {

    @Value("${wiremock.server.port}")
    String port;

    @Autowired
    @Qualifier("getInfoCommand")
    private MessageHandler messageHandler;

    @Test
    void getCustomerByUserId() {

        var update = new Update();
        var message = new Message();

        message.setText("/getInfo");
        message.setChat(new Chat(1L, ""));
        update.setMessage(message);

        String response = messageHandler.generateMessage(update);
        assertThat(response).isNotBlank().isEqualTo("Hello User");
    }
}
