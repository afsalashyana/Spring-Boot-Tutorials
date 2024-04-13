package com.genuinecoder.LearnSpringBoot;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class MySimpleDevController {

    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "Hi Humann!";
    }

    @GetMapping("/test")
    public String secondHome() {
        return "Prove me that you are not a robot!!";
    }

}
