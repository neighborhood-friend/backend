package per.neighborhood.friend.apis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import per.neighborhood.friend.applications.UserDetailService;
import per.neighborhood.friend.applications.UserService;
import per.neighborhood.friend.applications.dto.UserDetailResponse;
import per.neighborhood.friend.applications.dto.UserDetailUpdateRequest;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserApi {

    private final UserService userService;
    private final UserDetailService userDetailService;

    @GetMapping("/nickname/check-duplication")
    public boolean checkDuplicate(String nickname) {
        return userDetailService.checkDuplicate(nickname);
    }

    @PutMapping
    public UserDetailResponse changeUserDetail(@RequestBody UserDetailUpdateRequest userDetailUpdateRequest) {
        return userService.changeUserDetail(userDetailUpdateRequest);
    }
}
