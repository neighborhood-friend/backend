package per.neighborhood.friend.apis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neighborhood.friend.applications.KakaoService;
import per.neighborhood.friend.applications.UserService;
import per.neighborhood.friend.client.dto.KakaoAuthResponse;
import per.neighborhood.friend.client.dto.KakaoRegisterResponse;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
@Slf4j
public class KakaoLoginApi {

    private final KakaoService kakaoService;
    private final UserService userService;

    @GetMapping("/login")
    public KakaoAuthResponse login(String code) {
        log.info("kakao login code: {}", code);
        KakaoAuthResponse kakaoAuthResponse = kakaoService.login(code);
        KakaoRegisterResponse kakaoRegisterResponse = kakaoService.getUser(kakaoAuthResponse);
        userService.register(kakaoRegisterResponse);
        log.info("kakao login succeed: {}", kakaoAuthResponse);
        return kakaoAuthResponse;
    }
}
