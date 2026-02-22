package org.example.kato.dtos.User;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String authId;
    private String name;
    private String birthday;
    private String email;
}
