package springstudy.work.amber.springstudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*和servlet作用相同的访问网页的主页面的作用*/
@Controller
public class IndexController {
    @GetMapping("/")/*表示根目录*/
    public  String index(){
        return "index";
    }
}
