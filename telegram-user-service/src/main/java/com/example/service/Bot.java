package com.example.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    @Override
    public String getBotToken() {
        return "7154597435:AAGAK1knRKbus2_0J0uetBT5Jo9kR-D1BY0";
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        String messageText = update.getMessage().getText();

        if ("/start".equals(messageText)) {
            System.out.println("Hello!");
        }
    }
}