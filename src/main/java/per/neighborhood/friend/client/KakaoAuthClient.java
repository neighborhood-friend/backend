package per.neighborhood.friend.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class KakaoAuthClient {

    private final ObjectMapper objectMapper;

    public KakaoService service() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .readTimeout(5, TimeUnit.MINUTES)
            .build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://kauth.kakao.com")
            .addConverterFactory(
                JacksonConverterFactory.create(objectMapper)
            )
            .client(okHttpClient)
            .build();

        return retrofit.create(KakaoService.class);
    }
}
