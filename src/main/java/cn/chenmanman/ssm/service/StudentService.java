package cn.chenmanman.ssm.service;

import cn.chenmanman.ssm.model.entity.Student;
import cn.chenmanman.ssm.model.entity.User;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getStudentAll();

    boolean insertStudent(Student student);

    boolean removeStudentByIds(List<Integer> ids);


}
