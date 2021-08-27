package per.neighborhood.friend.apis;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/kakao")
public class KakaoLoginApi {

    @PostMapping("/login")
    public String login() {
        return "Kakao Login";
    }
}
