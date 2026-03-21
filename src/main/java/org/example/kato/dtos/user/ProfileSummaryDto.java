package org.example.kato.dtos.user;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProfileSummaryDto {
    private UUID id;
    private String handle;
    private String name;
    private ProfileMediaDto avatar;
    private ProfileMediaDto banner;
}