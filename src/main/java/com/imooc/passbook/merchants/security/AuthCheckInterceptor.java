package com.imooc.passbook.merchants.security;

import com.imooc.passbook.merchants.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 * 拦截所有的http请求
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    /**
     * 如果一个http请求没有携带token信息，那么就不能通过校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.TOKEN_STRING);
        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header中缺少 " + Constants.TOKEN_STRING + "!");
        }

        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Header 中 " + Constants.TOKEN_STRING + "错误！");
        }

        //通过校验的话，就代表token正确
        AccessContext.setToken(token);

        //返回true
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
