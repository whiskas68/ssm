package com.jaywade.myoa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {

        String url = request.getRequestURI();
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("employee")!=null){
            return true;
        }
        response.sendRedirect("/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws  Exception{

    }

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object obj, Exception e) throws  Exception{
    }
}
