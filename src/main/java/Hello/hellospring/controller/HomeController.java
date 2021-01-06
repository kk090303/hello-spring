package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //첫번쨰 홈 페이지에 home이 호출됌
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
