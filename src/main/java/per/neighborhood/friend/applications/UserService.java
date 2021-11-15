package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import per.neighborhood.friend.applications.dto.UserDetailResponse;
import per.neighborhood.friend.applications.dto.UserDetailUpdateRequest;
import per.neighborhood.friend.applications.exception.NotFoundUserException;
import per.neighborhood.friend.client.dto.KakaoRegisterResponse;
import per.neighborhood.friend.domain.User;
import per.neighborhood.friend.domain.UserDetail;
import per.neighborhood.friend.domain.UserDetailRepository;
import per.neighborhood.friend.domain.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void register(KakaoRegisterResponse kakaoRegisterResponse) {
        if (userRepository.existsByAuthId(kakaoRegisterResponse.getId())) {
            return;
        }

        UserDetail userDetail = userDetailRepository.save(
            UserDetail.builder()
                .socialNickname(kakaoRegisterResponse.getKakaoAccount().getProfile().getNickname())
                .thumbnailImageUrl(kakaoRegisterResponse.getKakaoAccount().getProfile().getThumbnailImageUrl())
                .profileImageUrl(kakaoRegisterResponse.getKakaoAccount().getProfile().getProfileImageUrl())
                .isDefaultImage(kakaoRegisterResponse.getKakaoAccount().getProfile().isDefaultImage())
                .build()
        );

        userRepository.save(
            User.builder()
                .authId(kakaoRegisterResponse.getId())
                .email(kakaoRegisterResponse.getKakaoAccount().getEmail())
                .userDetail(userDetail)
                .build()
        );
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetailResponse changeUserDetail(UserDetailUpdateRequest userDetailUpdateRequest) {
        User user = userRepository.findById(userDetailUpdateRequest.getUserId())
            .orElseThrow(NotFoundUserException::new);
        UserDetail userDetail = userDetailRepository.findById(user.getUserDetail().getId())
            .orElseThrow(NotFoundUserException::new);

        userDetail.change(
            UserDetail.builder()
                .nickname(userDetailUpdateRequest.getNickname())
                .build()
        );

        return UserDetailResponse.builder()
            .nickname(userDetail.getNickname())
            .build();
    }
}
