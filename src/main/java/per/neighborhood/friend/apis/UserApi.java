package per.neighborhood.friend.apis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neighborhood.friend.applications.UserDetailService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserApi {

    private final UserDetailService userDetailService;

    @GetMapping("/nickname/check-duplication")
    public boolean checkDuplicate(String nickname) {
        return userDetailService.checkDuplicate(nickname);
    }
}
