package springstudy.work.amber.springstudy.dto;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*第二步，GitHub的用户信息，其实是provider的返回值*/
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }



}
