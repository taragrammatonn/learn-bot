package com.example.message.handler;

import com.example.commons.integratiom.test.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
class StartCommandTest {

    @Value("${wiremock.server.port")
    String port;

    @Autowired
    private MessageHandler messageHandler;

    @Test
    void getCustomerByUserId() {
        Update update = new Update();
        Message message = new Message();
        message.setChat(new Chat(1L, ""));
        update.setMessage(message);

        String s = messageHandler.generateMessage(update);
        assertThat(s).isNotBlank().isEqualTo("{\"connection\":true}");

    }
}