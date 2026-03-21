package org.example.kato.entities.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kato.entities.user.Profile;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "abstract_content", nullable = false)
    private String abstractContent;

    @Column(name = "type", nullable = false)
    private PostType type;

    @Column(
            name = "created_at",
            nullable = false
    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at",
            nullable = false
    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // RELATIONAL MAPPINGS

    // ONE TO MANY: Profile < Post

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // ONE TO ONE: Post - PostMedia (Thumbnail)

    @OneToOne(mappedBy = "post")
    private PostMedia postMedia;

    // MANY TO MANY: Post <> Tag (via JoinTable PostTags)

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags;
}
