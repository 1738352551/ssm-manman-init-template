package cn.chenmanman.ssm.model.dto.menu;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuAddRequest implements Serializable {

    private Long parentId;

    private String parentName;

    private String name;

    private String perms;

    private String component;

    private Integer status;

    private String path;

    private Integer order;

    private static final long serialVersionUID = 6059422918201802797L;
}
