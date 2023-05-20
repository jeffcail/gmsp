package com.caixiaoxin.gmsp.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

    private static IUserService staticUserService;

    @Resource
    private IUserService userService;

    @PostConstruct
    public void setUserService() {
        staticUserService = userService;
    }


    /**
     * 生成 Token
     * @param uid
     * @param sign
     * @return
     */
    public static String generateToken(String uid, String sign) {
        return JWT.create().withAudience(uid)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2小时后过期
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 获取当前登陆的用户信息
     * @return
     */
    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (!StrUtil.isBlank(token)) {
                String uid = JWT.decode(token).getAudience().get(0);
                return staticUserService.getById(Integer.valueOf(uid));
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

}
