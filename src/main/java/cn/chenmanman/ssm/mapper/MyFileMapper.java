package cn.chenmanman.ssm.mapper;

import cn.chenmanman.ssm.model.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyFileMapper {
    int addFile(MyFile myFile);
}
