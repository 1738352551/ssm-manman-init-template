package cn.chenmanman.ssm.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity{

    private String name;

    private Long parentId;

    private String parentName;

    private String path;

    private String component;

    private String perms;

    private String icon;

    private Integer order;


}
