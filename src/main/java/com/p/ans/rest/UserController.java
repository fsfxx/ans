package com.p.ans.rest;

import com.p.ans.domain.User;
import com.p.ans.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository ur;

    public UserController(UserRepository ur) {
        this.ur = ur;
    }

    @GetMapping
    Iterable<User> all() {
        return ur.findAll();
    }

}
