package per.neighborhood.friend.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neighborhood.friend.applications.KakaoService;
import per.neighborhood.friend.client.dto.KakaoAuthResponse;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoLoginApi {

    private final KakaoService kakaoService;

    @GetMapping("/login")
    public KakaoAuthResponse login(String code) {
        return kakaoService.login(code);
    }
}
