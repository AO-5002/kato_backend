package org.example.kato.service;

import org.example.kato.entities.user.User;
import org.example.kato.mappers.UserMapper;
import org.example.kato.repositories.UserRepository;
import org.example.kato.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserBasedOnAuth() {

//        User mockUser = User.builder().id(UUID.randomUUID()).authId().name().email();

    }
}
