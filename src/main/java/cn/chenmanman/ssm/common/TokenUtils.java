package cn.chenmanman.ssm.common;

import cn.chenmanman.ssm.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private static String key = "token123456";

    public static String getToken(Map<String, Object> claim) {//User user
        String token = null;
//签发的时间
        long now = System.currentTimeMillis();
        Date nowdate = new Date(now);
//过期时间
        long exp = now + 4 * 24 * 24 * 1000L;
        Date expdate = new Date(exp);//加密算法I
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        token = Jwts.builder().setClaims(claim).setIssuedAt(nowdate).setExpiration(expdate).signWith(signatureAlgorithm, key).compact();
        return token;

    }

    public static void main(String[] args) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("user", new User());
        System.out.println(getToken(objectObjectHashMap));
    }
}
