package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.codec.Base64Encoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(value = "验证码", tags = {"验证码"})
@RestController
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/checkCode")
    public BaseResponse checkCode() {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        HashMap<String, Object> result = new HashMap<>();
        result.put("captchaUUID", UUID.randomUUID());
        result.put("imageBase64", lineCaptcha.getImageBase64Data());
        redisTemplate.opsForValue().set("code:"+result.get("captchaUUID") , lineCaptcha.getCode(), 60, TimeUnit.SECONDS);
        return ResultUtils.success(result);
    }
}
