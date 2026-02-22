package org.example.kato.dtos.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserDto {
    @NotNull(message = "AuthID is NOT valid!")
    private String authId;

    @NotNull(message = "Name is NOT valid!")
    private String name;

    @NonNull
    @Email(message = "Email NOT valid!")
    private String email;
}
