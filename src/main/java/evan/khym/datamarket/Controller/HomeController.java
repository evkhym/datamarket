package evan.khym.datamarket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/board")
    public String board() {
        return "board";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/datasets")
    public String datasets() {
        return "datasets";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/message")
    public String message() {
        return "message";
    }
    @GetMapping("/upload")
    public String upload() { return "upload"; }
}
