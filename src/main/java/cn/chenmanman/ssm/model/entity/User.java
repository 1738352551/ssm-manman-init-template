package cn.chenmanman.ssm.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    private Integer gender;

    private String email;
    private String avatar;

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
    private static final long serialVersionUID = -3729645889487710337L;
}
