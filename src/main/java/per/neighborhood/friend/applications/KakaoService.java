package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neighborhood.friend.client.KakaoApiClient;
import per.neighborhood.friend.client.KakaoAuthClient;
import per.neighborhood.friend.client.dto.KakaoAuthResponse;
import per.neighborhood.friend.client.dto.KakaoRegisterResponse;
import retrofit2.Response;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoService {

    private static final String AUTHORIZATION_CODE = "authorization_code";

    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoApiClient kakaoApiClient;

    public KakaoAuthResponse login(String code) {
        try {
            Response<KakaoAuthResponse> kakaoAuthResponse = kakaoAuthClient.service()
                .requestAccessToken(
                    AUTHORIZATION_CODE,
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
            log.error("카카오 로그인 통신 오류 발생: {}", kakaoAuthResponse);
        }
    }

    public KakaoRegisterResponse getUser(KakaoAuthResponse kakaoAuthResponse) {
        try {
            Response<KakaoRegisterResponse> kakaoRegisterResponse = kakaoApiClient.service()
                .requestUserDetail(
                    "Bearer " + kakaoAuthResponse.getAccess_token()
                ).execute();

            return kakaoRegisterResponse.body();
        } catch (IOException ioException) {
            log.error("카카오 정보 요청 오류 발생: ", ioException);
            return KakaoRegisterResponse.builder().build();
        }
    }
}
