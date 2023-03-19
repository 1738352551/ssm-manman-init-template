package cn.chenmanman.ssm.model.dto.role;


import cn.chenmanman.ssm.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleQueryRequest extends PageRequest implements Serializable  {



    private Long id;

    private String name;

    private static final long serialVersionUID = 7042938406022744701L;
}
