package com.zxin.java.spring.validate;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author zxin
 */
@Data
public class Staff {

    @Min(10)
    @Max(1000)
    private Integer id;

    @NotEmpty
    private String name;
    @NotNull
    private Boolean man;

    private LocalDate hireDate;

    @PositiveOrZero
    private BigDecimal salary;

    @Email
    private String email;


}
