package org.example.kato.entities.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kato.entities.post.Post;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "handle", unique = true, nullable = false)
    private String handle;

    @Column(name = "bio")
    private String bio;

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

    // ONE TO ONE: User - Profile

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // ONE TO ONE: Profile - ProfileMedia (Profile Picture)

    @OneToOne(mappedBy = "profile")
    private ProfileMedia profileMedia;

    // ONE TO MANY: Profile < Post

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL ,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Post> posts;
}
