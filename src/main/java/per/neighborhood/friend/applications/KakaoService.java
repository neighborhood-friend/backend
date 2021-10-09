package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neighborhood.friend.client.KakaoClient;
import per.neighborhood.friend.client.dto.KakaoAuthResponse;
import retrofit2.Response;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoService {

    private final KakaoClient kakaoClient;

    public KakaoAuthResponse login(String code) {
        log.info("kakao login code: {}", code);

        try {
            Response<KakaoAuthResponse> kakaoAuthResponse = kakaoClient.service().requestAccessToken(
                "authorization_code",
                "f407a0ea17dec6717cc52af58d4aa5f2",
                "http://localhost:8080/kakao/login",
                code,
                "PMwvP599EYVottDXJM2wLtHCD10GRUPN"
            ).execute();

            checkSuccessful(kakaoAuthResponse);
            return kakaoAuthResponse.body();
        } catch (IOException ioException) {
            log.error("카카오 로그인 오류 발생: ", ioException);
            return KakaoAuthResponse.builder().build();
        }
    }

    private void checkSuccessful(Response<KakaoAuthResponse> kakaoAuthResponse) {
        if (!kakaoAuthResponse.isSuccessful()) {
            log.error("카카오 로그인 오류 발생: {}", kakaoAuthResponse.raw());
        }
    }
}
