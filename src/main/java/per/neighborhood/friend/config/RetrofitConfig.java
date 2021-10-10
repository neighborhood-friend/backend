package per.neighborhood.friend.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit commonRetrofit(ObjectMapper objectMapper) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return new Retrofit.Builder()
            .baseUrl("https://dummy") // baseUrl 은 생략, 각 서비스에서 필요할 때 재정의해서 사용
            .addConverterFactory(JacksonConverterFactory.create())
            .client(new OkHttpClient.Builder().build())
            .build();
    }
}
