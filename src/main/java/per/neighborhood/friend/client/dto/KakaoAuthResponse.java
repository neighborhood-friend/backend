package per.neighborhood.friend.client.dto;

import lombok.*;

@Builder
@Getter
@ToString
public class KakaoAuthResponse {
    private final String token_type;
    private final String access_token;
    private final Integer expires_in;
    private final String refresh_token;
    private final Integer refresh_token_expires_in;
    private final String scope;
}
