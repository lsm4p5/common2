package com.lguplus.common.web.formdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String loginname;

    @NotEmpty
    private String password;
}
