package cn.chenmanman.ssm.model.dto.user;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryRequest implements Serializable {

    private String username;

    private Integer gender;

    private String email;

    private Integer status;
    private static final long serialVersionUID = 4353935766280359746L;
}
