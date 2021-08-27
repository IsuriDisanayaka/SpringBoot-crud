package lk.wixis.springboot.interceptor;

import lk.wixis.springboot.util.AppConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Isuri Disanayaka
 * @date:27/08/2021
 * @since : 0.0.1
 **/
@Component
public class UserInInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(AppConstant.ROOT_URL.equals(request.getRequestURI()) ||request.getRequestURI().equalsIgnoreCase("/error")){
            response.sendRedirect("/api/userform");

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

