package per.neighborhood.friend.applications.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailResponse {
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("thumbnailImageUrl")
    private String thumbnailImageUrl;
    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
}
