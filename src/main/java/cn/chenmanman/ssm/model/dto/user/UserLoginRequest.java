package cn.chenmanman.ssm.model.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    @NotNull(message = "账号不能为空!")
    private String username;


    @NotNull(message = "密码不能为空!")
    private String password;


    private String code;
    private String uuid;

    private static final long serialVersionUID = 7514228079120445817L;
}
