package per.neighborhood.friend.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class KakaoRegisterResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;
}
