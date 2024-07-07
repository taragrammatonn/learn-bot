package com.example.service;

import com.example.commons.unit.test.UnitTest;
import com.example.dao.UserDAO;
import com.example.dao.model.Transaction;
import com.example.dao.model.User;
import com.example.factory.TransactionFactory;
import com.example.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@UnitTest
class UserServiceUnitTest {

    @Mock
    private UserDAO userDAO;

    private TelegramUserService telegramUserService;


    @BeforeEach
    void setUp() {
        telegramUserService = new TelegramUserServiceImpl(userDAO);
    }

    @Test
    void shouldReturnById() {
        User user = UserFactory.aUserWithId();

        when(userDAO.findById(any())).thenReturn(Optional.of(user));

        Optional<User> userById = telegramUserService.findById(user.getId());

        assertSoftly(softAssertions -> {
           softAssertions.assertThat(userById).isPresent();
           userById.ifPresent(value -> softAssertions.assertThat(user).usingRecursiveComparison().isEqualTo(value));
        });
    }

    @Test
    void shouldNotReturnWhenIdNotFound() {
        User user = UserFactory.aUser();

        when(userDAO.findById(any())).thenReturn(Optional.empty());

        Optional<User> userById = telegramUserService.findById(user.getId());

        assertThat(userById).isEmpty();
    }

    @Test
    void shouldSaveById() {
        User user = UserFactory.aUserWithId();

        when(userDAO.save(any())).thenReturn(user);

        User userById = telegramUserService.save(user.getId(), user);

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(userById).isNotNull();
            softAssertions.assertThat(user).usingRecursiveAssertion().isEqualTo(userById);
        });
    }

    @Test
    void shouldDeleteById() {
        User user = UserFactory.aUserWithId();

        doNothing().when(userDAO).deleteById(user.getId());

        boolean deleteById = telegramUserService.deleteById(user.getId());

        assertThat(deleteById).isTrue();
    }

    @Test
    void shouldNotDeleteWhenIdNotFound() {
        User user = UserFactory.aUser();

        doThrow(RuntimeException.class).when(userDAO).deleteById(user.getId());

        boolean deleteById = telegramUserService.deleteById(user.getId());

        assertThat(deleteById).isFalse();
    }

    @Test
    void shouldReturnTransactionByUser() {

        User testUser = UserFactory.aUserWithId();
        Transaction testTransaction = TransactionFactory.aTransactionWithId();

        testUser.setTransaction(List.of(testTransaction));

        assertThat(testUser.getTransaction()).isEqualTo(List.of(testTransaction));
    }
}
