package com.lu.workManageSystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginHandlerInterceptor
 * @Description:
 * @Author: luning
 * @Date: 2021/10/21 21:15
 * @Version: v1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session

        Object teacher = request.getSession().getAttribute("teacher");
        Object student = request.getSession().getAttribute("student");
        if(teacher == null && student == null){
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }
}
