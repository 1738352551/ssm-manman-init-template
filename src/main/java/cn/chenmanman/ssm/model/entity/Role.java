package cn.chenmanman.ssm.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Role extends BaseEntity implements Serializable {

    private String name;

    public static boolean isAdmin(Long id)
    {
        return id != null && 1L == id;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.getId());
    }
    private static final long serialVersionUID = -4119367011139499812L;
}
