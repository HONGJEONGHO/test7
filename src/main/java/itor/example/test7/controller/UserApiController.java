package itor.example.test7.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @RequestMapping("/test")
    public String UserLogin() {
        return "true";
    }

    @RequestMapping("/testU")
    public UserVO UserLogin2() {

        UserVO user = new UserVO();
        user.setUser_id("testetst");
        return user;
    }
}
