package com.example.service;

import com.example.dao.UserDAO;
import com.example.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {

    private final UserDAO userDAO;

    @Autowired
    public TelegramUserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(Long id, User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean deleteById(Long userId) {
        try {
            userDAO.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
