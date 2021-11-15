package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neighborhood.friend.domain.UserDetailRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailService {

    private final UserDetailRepository userDetailRepository;

    public boolean checkDuplicate(String nickname) {
        return userDetailRepository.existsByNickname(nickname);
    }
}
