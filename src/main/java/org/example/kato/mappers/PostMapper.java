package org.example.kato.mappers;

import lombok.RequiredArgsConstructor;
import org.example.kato.dtos.post.PostItemDto;
import org.example.kato.entities.post.Post;
import org.example.kato.entities.post.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostMapper {

    private final ProfileMapper profileMapper;

    public PostItemDto toPostItemDto(Post post) {
        return PostItemDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .abstractContent(post.getAbstractContent())
                .type(post.getType())
                .thumbnailS3Key(
                        post.getPostMedia() != null
                                ? post.getPostMedia().getS3Key()
                                : null
                )
                .tags(
                        post.getTags() != null
                                ? post.getTags().stream()
                                .map(Tag::getName)
                                .collect(Collectors.toList())
                                : List.of()
                )
                .profile(profileMapper.toProfileSummaryDto(post.getProfile()))
                .build();
    }

    public List<PostItemDto> toPostItemDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::toPostItemDto)
                .collect(Collectors.toList());
    }
}