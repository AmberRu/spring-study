package springstudy.work.amber.springstudy.Controller;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springstudy.work.amber.springstudy.dto.AccessTokenDTO;
import springstudy.work.amber.springstudy.dto.GithubUser;
import springstudy.work.amber.springstudy.provider.GithubProvider;

import java.io.IOException;

/*通过点击登录按钮，进行页面之间的跳转，直接跳转到GitHub是否授权页面*/
@Controller
public class AuthorizeController {
    @Autowired
     private GithubProvider githubProvider;
    //读取配置文件中的值
    @Value("${github.client.id}")
    private String clientId;//将properties的东西注进来
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri")
    private String  redirectUri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String  accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());
     return "index";
    }
}
