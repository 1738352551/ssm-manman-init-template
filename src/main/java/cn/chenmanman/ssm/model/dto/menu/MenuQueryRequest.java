package cn.chenmanman.ssm.model.dto.menu;


import lombok.Data;

import java.io.Serializable;

@Data
public class MenuQueryRequest implements Serializable {

    private Long parentId;

    private String parentName;

    private String name;

    private String perms;

    private String component;

    private Integer status;

    private String path;

    private static final long serialVersionUID = 7621409711953433879L;
}
