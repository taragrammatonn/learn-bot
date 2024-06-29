package com.example.service;

import com.example.commons.integratiom.test.IntegrationTest;
import com.example.dao.UserDAO;
import com.example.dao.model.User;
import com.example.factory.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@IntegrationTest
class UserServiceTest {

    static PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    private TelegramUserService telegramUserService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private UserDAO userDAO;

    private MockMvc mvc;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @BeforeEach
    void setUp() {
        userDAO.deleteAll();

        userDAO.save(
                User.builder()
                        .id(1L)
                        .lName("qwe")
                        .fName("qwe")
                        .build()
        );
    }

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .build();
    }

    @Test
    void shouldReturnTestUserFromDB() {
        assertThat(userDAO.findById(1L)).isPresent();
    }

    @Test
    void shouldReturnUserById() throws Exception {

        var testUser = UserFactory.aUserWithId();

        var objectMapper = new ObjectMapper();
        var userJson = objectMapper.writeValueAsString(testUser);

        when(userDAO.findById(testUser.getId())).thenReturn(Optional.of(testUser));

        mvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(userJson, true));
    }

    @BeforeAll
    static void beforeAll() {
        postgresContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgresContainer.stop();
    }
}
