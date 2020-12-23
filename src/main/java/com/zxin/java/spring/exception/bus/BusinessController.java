package com.zxin.java.spring.exception.bus;

import com.zxin.java.spring.exception.BusExceptionEnum;
import com.zxin.java.spring.exception.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @GetMapping("/result")
    public Result<String> result(@RequestParam String name){
        throw BusExceptionEnum.INNER_CALL_EXCEPTION.busException();
    }
}
