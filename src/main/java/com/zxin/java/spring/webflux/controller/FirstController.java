package com.zxin.java.spring.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/api/webflux/")
public class FirstController {

    @GetMapping("mono")
    public Mono<String> mono() {
        return Mono.just("hello webflux");
    }

}
