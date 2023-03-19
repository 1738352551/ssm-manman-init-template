package cn.chenmanman.ssm.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddRequest implements Serializable {
    private static final long serialVersionUID = -652858759913717577L;
    /**
     * 账号
     * */
    private String username;
    /**
     * 密码
     * */
    private String password;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 性别
     * */
    private Integer gender;
    /**
     * 头像地址
     * */
    private String avatar;


}
