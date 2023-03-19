package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.chenmanman.ssm.model.entity.Student;
import cn.chenmanman.ssm.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "学生管理(练习用)", tags = {"学生管理(练习用)"})
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public BaseResponse<?> queryStudentAll() {

        return ResultUtils.success(studentService.getStudentAll());
    }

    @PostMapping
    public BaseResponse<?> addStudent(@RequestBody Student student) {
        return studentService.insertStudent(student) ? ResultUtils.success(null):ResultUtils.error(500, "添加失败");
    }

    @DeleteMapping
    public BaseResponse<?> removeStudent(@RequestBody List<Integer> ids) {
        return studentService.removeStudentByIds(ids) ? ResultUtils.success(null):ResultUtils.error(500, "删除失败");
    }


    @GetMapping
    public BaseResponse<?> findStudentAll() {
        return ResultUtils.success(studentService.getStudentAll());
    }
}
