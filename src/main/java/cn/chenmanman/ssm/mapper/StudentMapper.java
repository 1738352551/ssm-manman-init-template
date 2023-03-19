package cn.chenmanman.ssm.mapper;


import cn.chenmanman.ssm.model.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 查询表中所有的学生
     * @author 陈慢慢
     * */
    List<Student> selectStudentAll();

    int insertStudent(Student student);

    int deleteStudentByIds(List<Integer> ids);
}
