package org.example.kato.mappers;

import org.example.kato.dtos.User.CreateUserDto;
import org.example.kato.entities.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    CreateUserDto createUserDtoToUser(User user);

}
