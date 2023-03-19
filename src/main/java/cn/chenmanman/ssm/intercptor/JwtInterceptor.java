package cn.chenmanman.ssm.intercptor;

import cn.chenmanman.ssm.exception.BusinessException;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (Objects.isNull(token) || token.isEmpty()) {
            throw new BusinessException(5000, "请携带Token请求接口!");
        }

        // 验证失败异常会被异常处理器拦截
        JWTValidator verify = JWTValidator.of(token).validateDate();



        return true;
    }
}
