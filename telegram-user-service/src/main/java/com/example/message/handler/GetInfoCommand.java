package com.example.message.handler;

import com.example.resource.CustomerProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class GetInfoCommand implements MessageHandler {

    @Autowired
    private CustomerProductApi customerProductApi;

    @Override
    public String command() {
        return "/getInfo";
    }

    @Override
    public String generateMessage(Update update) {
        return prepareMessage(customerProductApi.getCustomerId(update.getMessage().getChatId().toString()));
    }

    private String prepareMessage(String userId) {
        return "Hello User";
    }
}
