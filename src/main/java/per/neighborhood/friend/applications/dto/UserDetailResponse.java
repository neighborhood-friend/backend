package per.neighborhood.friend.applications.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@ToString
public class UserDetailResponse {
    @JsonProperty("nickname")
    private String nickname;
}
