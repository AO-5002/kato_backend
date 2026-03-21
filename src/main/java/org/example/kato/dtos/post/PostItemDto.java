package org.example.kato.dtos.post;

import lombok.Builder;
import lombok.Data;
import org.example.kato.dtos.user.ProfileSummaryDto;
import org.example.kato.entities.post.PostStatus;
import org.example.kato.entities.post.PostType;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PostItemDto {
    private UUID id;
    private String title;
    private String abstractContent;
    private PostStatus status;
    private PostType mediaType;
    private String thumbnailS3Key;
    private List<String> tags;
    private ProfileSummaryDto profile;  // just a nested plain object
}