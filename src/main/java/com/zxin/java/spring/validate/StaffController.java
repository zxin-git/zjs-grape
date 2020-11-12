package com.zxin.java.spring.validate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @PostMapping("/info")
    public String staff(@RequestBody @Valid Staff staff){
        System.out.println(staff);
        return staff.getName();
    }

}
