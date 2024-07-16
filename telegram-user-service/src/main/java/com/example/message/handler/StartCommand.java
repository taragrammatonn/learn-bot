package com.example.message.handler;

import com.example.resource.CustomerProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements MessageHandler {

    @Autowired
    private CustomerProductApi customerProductApi;

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String generateMessage(Update update) {
        return customerProductApi.getCustomerId(update.getMessage().getChatId().toString());
    }
}
