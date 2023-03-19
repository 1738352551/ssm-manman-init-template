package cn.chenmanman.ssm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile implements Serializable {

    private static final long serialVersionUID = 6667314882324730582L;
    private Integer id;

    private String filename;

    private String filepath;

    private Double size;

    private LocalDateTime updatetime;
}
