package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neighborhood.friend.client.dto.KakaoRegisterResponse;
import per.neighborhood.friend.domain.User;
import per.neighborhood.friend.domain.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void register(KakaoRegisterResponse kakaoRegisterResponse) {
        if (userRepository.existsByAuthId(kakaoRegisterResponse.getId())) {
            return;
        }

        userRepository.save(
            User.builder()
                .authId(kakaoRegisterResponse.getId())
                .email(kakaoRegisterResponse.getKakaoAccount().getEmail())
                .nickname(kakaoRegisterResponse.getKakaoAccount().getProfile().getNickname())
                .build()
        );
    }
}
