package org.example.kato.mappers;

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
                .avatarS3Key(
                        profile.getProfileMedia() != null
                                ? profile.getProfileMedia().getS3Key()
                                : null
                )
                .build();
    }
}