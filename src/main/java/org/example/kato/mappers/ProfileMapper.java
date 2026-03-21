package org.example.kato.mappers;

import org.example.kato.dtos.user.ProfileMediaDto;
import org.example.kato.dtos.user.ProfileSummaryDto;
import org.example.kato.entities.user.Profile;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public ProfileSummaryDto toProfileSummaryDto(Profile profile) {
        return ProfileSummaryDto.builder()
                .id(profile.getId())
                .handle(profile.getHandle())
                .name(profile.getName())
                .avatar(profile.getProfileMedia() != null
                        ? ProfileMediaDto.builder()
                        .id(profile.getProfileMedia().getId())
                        .profileId(profile.getId())
                        .s3Key(profile.getProfileMedia().getS3Key())
                        .build()
                        : null)
                .banner(null) // add banner entity/mapping later
                .build();
    }
}