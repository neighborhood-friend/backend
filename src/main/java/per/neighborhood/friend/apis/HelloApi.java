package per.neighborhood.friend.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot";
    }
}