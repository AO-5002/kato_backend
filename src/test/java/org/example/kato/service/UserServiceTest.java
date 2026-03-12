package org.example.kato.service;

import org.example.kato.dtos.user.CreateUserDto;
import org.example.kato.entities.user.User;
import org.example.kato.exceptions.user.UserNotFoundException;
import org.example.kato.mappers.UserMapper;
import org.example.kato.repositories.UserRepository;
import org.example.kato.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    // Mock User
    private User existingUser;
    private CreateUserDto createUserDto;

    @BeforeEach
    public void setUp() {
        existingUser = User.builder().
                id(UUID.randomUUID()).
                authId("apple-123").
                name("Andres").
                email("andres@gmail.com").
                build();
    }

    @Test
    public void testGetUserBasedOnAuth() {

        when(userRepository.findByAuthId("apple-123")).thenReturn(Optional.of(existingUser));
        User result = userService.getUserBasedOnAuth("apple-123");
        assertEquals(existingUser, result);
    }

    @Test
    public void testGetUserNotFound() {

        when(userRepository.findByAuthId("apple-245")).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserBasedOnAuth("apple-245");
        });
    }




}
