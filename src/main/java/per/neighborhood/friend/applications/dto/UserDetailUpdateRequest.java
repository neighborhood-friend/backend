package per.neighborhood.friend.applications.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class UserDetailUpdateRequest {
    @JsonProperty("id")
    private Long userId;
    @JsonProperty("nickname")
    private String nickname;
}
