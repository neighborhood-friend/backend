package per.neighborhood.friend.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Profile {
    @JsonProperty("nickname")
    private String nickname;
}
