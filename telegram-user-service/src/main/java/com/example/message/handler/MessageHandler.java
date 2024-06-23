package com.example.message.handler;

import com.example.service.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public interface MessageHandler {

    String command();

    String generateMessage(Update update);

    @Autowired
    default void initCommand(Bot bot) {
        bot.addCommandHandler(command(), this);
    }

}
