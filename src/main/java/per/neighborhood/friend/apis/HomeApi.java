package per.neighborhood.friend.apis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeApi {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
