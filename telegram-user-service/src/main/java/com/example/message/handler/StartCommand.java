package com.example.message.handler;

import com.example.model.UserDto;
import com.example.resource.CustomerProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
        return prepareMessage(customerProductApi.saveOrGet(update.getMessage().getChatId().toString(),
                new UserDto(
                        update.getMessage().getChatId(),
                        update.getMessage().getChat().getFirstName(),
                        update.getMessage().getChat().getLastName(),
                        update.getMessage().getChat().getUserName()
                )
        ));
    }

    private String prepareMessage(UserDto userDto) {
        return "Hello World!";
    }
}
