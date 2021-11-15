package per.neighborhood.friend.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    boolean existsByNickname(String nickname);
}
