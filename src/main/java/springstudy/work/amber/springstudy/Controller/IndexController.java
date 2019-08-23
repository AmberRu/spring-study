package springstudy.work.amber.springstudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")/*表示根目录*/
    public  String index(){
        return "index";
    }
}
