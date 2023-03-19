package cn.chenmanman.ssm.service.impl;

import cn.chenmanman.ssm.mapper.StudentMapper;
import cn.chenmanman.ssm.model.entity.Student;
import cn.chenmanman.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentAll() {
        System.out.println(123123);
        return studentMapper.selectStudentAll();
    }

    @Override
    public boolean insertStudent(Student student) {
        if (Objects.isNull(student)) return false;
        int i = studentMapper.insertStudent(student);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeStudentByIds(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size()==0) return false;
        int i = studentMapper.deleteStudentByIds(ids);
        if (i>0){
            return true;
        }
        return false;
    }
}
