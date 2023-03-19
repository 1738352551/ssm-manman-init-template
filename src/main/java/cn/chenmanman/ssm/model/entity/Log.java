package cn.chenmanman.ssm.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class Log   {
    private Long id;
    private String ip;

    private String controller;

    private String url;

    private LocalDateTime updateTime;

    private String method;

    private String param;
}
