package cn.chenmanman.ssm.common;


import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 分页请求
 *
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private Integer pageNum = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;

}
