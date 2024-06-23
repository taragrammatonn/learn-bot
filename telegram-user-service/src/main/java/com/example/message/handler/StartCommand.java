package com.example.message.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements MessageHandler {

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String generateMessage(Update update) {
        return "";
    }
}
