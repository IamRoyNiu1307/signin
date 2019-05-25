package com.nsh.signin.handlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("teacher");
        if(user == null){
            //未登陆，返回登陆页面
            request.setAttribute("login_error","没有权限请先登陆");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            //已登陆，放行请求
            return true;
        }
    }
}
