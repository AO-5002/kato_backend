package org.example.kato.dtos.post;
import lombok.Data;
import org.example.kato.entities.post.PostStatus;
import org.example.kato.entities.post.PostType;

@Data
public class CreatePostDto {

    private String title;
    private PostStatus status;

}
