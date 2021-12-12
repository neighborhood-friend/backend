package per.neighborhood.friend.domain;

import lombok.*;
import lombok.experimental.Accessors;
import per.neighborhood.friend.domain.utils.Util;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_nickname", length = 100)
    private String socialNickname;

    @Column(name = "nickname", length = 100, unique = true)
    private String nickname;

    @Column(name = "thumbnail_social_image_url", length = 500)
    private String thumbnailSocialImageUrl;

    @Column(name = "profile_social_image_url", length = 500)
    private String profileSocialImageUrl;

    @Column(name = "is_social_default_image", columnDefinition = "TINYINT(1)")
    @Accessors(fluent = true)
    private Boolean isSocialDefaultImage;

    @Column(name = "thumbnail_image_url", length = 500)
    private String thumbnailImageUrl;

    @Column(name = "profile_image_url", length = 500)
    private String profileImageUrl;

    @Column(name = "한 줄 소개", length = 500)
    private String description;

    public void change(UserDetail userDetail) {
        this.nickname = Util.checkChange(this.nickname, userDetail.nickname);
        this.thumbnailImageUrl = Util.checkChange(this.thumbnailImageUrl, userDetail.thumbnailImageUrl);
        this.profileImageUrl = Util.checkChange(this.profileImageUrl, userDetail.profileImageUrl);
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
