package com.example.service;

import com.example.message.handler.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Component
public class Bot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    Map<String, MessageHandler> commandHandlers = new HashMap<>();

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
        commandHandlers.get(update.getMessage().getText()).generateMessage(update);
    }

    public void addCommandHandler(String command, MessageHandler handler) {
        commandHandlers.put(command, handler);
    }
}