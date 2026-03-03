package org.example.kato.services;

import lombok.RequiredArgsConstructor;
import org.example.kato.dtos.user.CreateUserDto;
import org.example.kato.entities.user.User;
import org.example.kato.exceptions.user.UserAlreadyExistsException;
import org.example.kato.exceptions.user.UserNotFoundException;
import org.example.kato.mappers.UserMapper;
import org.example.kato.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // HELPER METHOD(S)

    public User getUserBasedOnAuth(String authToken) {
        return userRepository.findByAuthId(authToken)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void createUser(String auth, CreateUserDto userDtoParam) {

        // 1.) First check if the user exists already.

        if (userRepository.existsByAuthId((auth))) {
            throw new UserAlreadyExistsException("User already exists.");
        }

        // 2. Then, map the dto into a user entity & set the auth token

        var dtoToUser = userMapper.createUserDtoToUser(userDtoParam);
        dtoToUser.setAuthId(auth);

        // 3.) Save the user to the db

        userRepository.save(dtoToUser);
    }




}
