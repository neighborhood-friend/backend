package per.neighborhood.friend.client;

import per.neighborhood.friend.client.dto.KakaoAuthResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface KakaoService {

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<KakaoAuthResponse> requestAccessToken(
        @Field("grant_type") String grantType,
        @Field("client_id") String clientId,
        @Field("redirect_uri") String redirectUri,
        @Field("code") String code,
        @Field("client_secret") String clientSecret
    );
}
