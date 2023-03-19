package cn.chenmanman.ssm.model.dto.role;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleAddRequest implements Serializable {
    private static final long serialVersionUID = -6353027190606813324L;
    /**
     *
     * 角色名
     * */
    private String name;

}
