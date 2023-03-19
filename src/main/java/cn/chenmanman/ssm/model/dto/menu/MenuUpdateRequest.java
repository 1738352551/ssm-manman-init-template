package cn.chenmanman.ssm.model.dto.menu;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuUpdateRequest implements Serializable {


    private static final long serialVersionUID = -8042784837663944479L;

    private Long parentId;
    private String name;
    private String parentName;
    private String path;
    private String component;

    private String perms;

    private Integer order;

}
