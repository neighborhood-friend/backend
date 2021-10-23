package per.neighborhood.friend.applications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import per.neighborhood.friend.client.KakaoClient;
import per.neighborhood.friend.client.dto.KakaoAuthResponse;
import retrofit2.Response;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoService {

    private static final String AUTHORIZATION_CODE = "authorization_code";
    @Value("login.redirect-uri.kakao")
    private final String rediectUri;
    @Value("login.token.kakao.client-id")
    private final String clientId;
    @Value("login.token.kakao.client-secret")
    private final String clientSecret;

    private final KakaoClient kakaoClient;

    public KakaoAuthResponse login(String code) {
        try {
            Response<KakaoAuthResponse> kakaoAuthResponse = kakaoClient.service()
                .requestAccessToken(AUTHORIZATION_CODE, clientId, rediectUri, code, clientSecret)
                .execute();

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
}
