package com.p.ans.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xunxiao Ren on 2017/10/20.
 */

@Controller
@RequestMapping("/")
public class ClientController {
    @GetMapping
    public String home() {
        return "index.html";
    }
}
