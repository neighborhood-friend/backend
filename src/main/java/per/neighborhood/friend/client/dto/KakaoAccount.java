package per.neighborhood.friend.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class KakaoAccount {
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("email")
    private String email;
}
