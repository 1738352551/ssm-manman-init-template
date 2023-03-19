package cn.chenmanman.ssm.model.dto.role;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleUpdateRequest implements Serializable {
    private static final long serialVersionUID = -8182648817551494111L;

    private Long id;
    /**
     *
     * 角色名
     * */
    private String name;

}
