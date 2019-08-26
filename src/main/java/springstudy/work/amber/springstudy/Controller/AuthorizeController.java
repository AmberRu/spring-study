package springstudy.work.amber.springstudy.Controller;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("0a1db93932737edc4714");
        accessTokenDTO.setClient_secret("c73d7bc486975cf94c3e0693cede897bcab50fa7");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String  accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());
     return "index";
    }
}
