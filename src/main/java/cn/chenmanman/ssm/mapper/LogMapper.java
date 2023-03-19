package cn.chenmanman.ssm.mapper;

import cn.chenmanman.ssm.model.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int insertLog(Log log);
}
