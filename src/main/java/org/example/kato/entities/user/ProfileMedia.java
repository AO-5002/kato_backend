package org.example.kato.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "profile_medias")
public class ProfileMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "s3_key", unique = true)
    private String s3Key;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    // RELATIONAL MAPPINGS

    // ONE TO ONE: Profile - ProfileMedia (Profile Picture)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
}
