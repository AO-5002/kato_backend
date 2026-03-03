package org.example.kato.entities.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "post_medias")
public class PostMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "s3_key", unique = true)
    private String s3Key;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    // RELATIONAL MAPPING

    // ONE TO ONE: Post - PostMedia (Post Thumbnail)

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
}