package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.model.entity.Student;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/testRedis")
    public String testRedis(){
        Student student = new Student();
        student.setName("陈慢慢");
        student.setAge(999);
        student.setCid(1);
        student.setId(3);

        redisTemplate.opsForValue().set("student:3", JSONUtil.toJsonStr(student));
        String str = (String) redisTemplate.opsForValue().get("student:3");
        return str;
    }
}
