package com.example.ledoc.common.interceptor;

import com.example.ledoc.common.exception.MyException;
import com.example.ledoc.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author whl
 * @Description
 * @date 2023/4/30 23:37
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    /**
     * TODO: 规整一下拦截器的返回信息以及报错信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // http 的 header 中获得token
        String token = request.getHeader("authorization");
        // token 不存在
        if (token == null || "".equals(token)) {
            log.error("Token 不存在");
            throw new MyException(JwtUtil.header + "不能为空");
        }
        // 验证 token
        String sub = JwtUtil.validateToken(token);
        if (sub == null || "".equals(sub)) {
            log.error("Token 不正确");
            throw new MyException(JwtUtil.header + "失效，请重新登录。");
        }
        // 更新 token 有效时间 (如果需要更新其实就是产生一个新的 token)
        if (JwtUtil.isNeedUpdate(token)) {
            String newToken = JwtUtil.createToken(sub);
            response.setHeader(JwtUtil.USER_LOGIN_TOKEN, newToken);
        }
        return true;
    }
}
