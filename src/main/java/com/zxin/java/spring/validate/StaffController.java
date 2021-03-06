package com.zxin.java.spring.validate;

import com.zxin.java.spring.exception.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @PostMapping("/info")
    public Result<String> staff(@RequestBody @Validated Staff staff){
        System.out.println(staff);
        return Result.successData(staff.getName());
    }

    @GetMapping("/indexStaff")
    public Result<String> indexStaff(IndexRequest request){
        System.out.println(request);
        return Result.successData("");
    }


}
