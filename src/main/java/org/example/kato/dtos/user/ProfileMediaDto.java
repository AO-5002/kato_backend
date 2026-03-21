package org.example.kato.dtos.user;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProfileMediaDto {
    private UUID id;
    private UUID profileId;
    private String s3Key;
}