package org.example.kato.mappers;

import org.example.kato.dtos.user.CreateUserDto;
import org.example.kato.entities.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUserDtoToUser(CreateUserDto user);
    CreateUserDto userToCreateUserDto(User user);
}
