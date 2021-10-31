package per.neighborhood.friend.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "auth_id", updatable = false, nullable = false, unique = true)
    private Long authId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "nickname", length = 100)
    private String nickname;

    @Column(name = "thumbnail_image_url", length = 100)
    private String thumbnailImageUrl;

    @Column(name = "profile_image_url", length = 100)
    private String profileImageUrl;

    @Column(name = "is_default_image", columnDefinition = "TINYINT(1)")
    @Accessors(fluent = true)
    private Boolean isDefaultImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
