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
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_nickname", length = 100)
    private String socialNickname;

    @Column(name = "nickname", length = 100, unique = true)
    private String nickname;

    @Column(name = "thumbnail_image_url", length = 500)
    private String thumbnailImageUrl;

    @Column(name = "profile_image_url", length = 500)
    private String profileImageUrl;

    @Column(name = "is_default_image", columnDefinition = "TINYINT(1)")
    @Accessors(fluent = true)
    private Boolean isDefaultImage;

    public void change(UserDetail userDetail) {
        this.nickname = userDetail.nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetail that = (UserDetail) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
