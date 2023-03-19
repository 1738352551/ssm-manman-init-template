package cn.chenmanman.ssm.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 删除请求
 *
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private List<Long> id;

    private static final long serialVersionUID = 1L;
}