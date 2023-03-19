package cn.chenmanman.ssm.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 6305348213508339597L;

    private Integer id;

    private String name;

    private Integer age;

    private Integer cid;
}
