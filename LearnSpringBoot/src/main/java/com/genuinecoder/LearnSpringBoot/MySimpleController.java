package com.genuinecoder.LearnSpringBoot;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("prod")
public class MySimpleController {

    private final Calculator calculator;

    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String secondHome() {
        return "Hello World2!";
    }

    //localhost:8500/sum?a=6&b=7
    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.calculateSum(a, b);
    }

}
