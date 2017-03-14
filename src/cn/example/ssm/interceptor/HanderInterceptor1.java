
package cn.example.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
类名：HanderInterceptor1.java
创建人-->Wang JJ
创建时间：2017年3月9日下午2:19:48
description：springmvc的拦截器
*/
public class HanderInterceptor1  implements HandlerInterceptor{

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor...afterCompletion");
		
	}
//进入handler方法之后，返回modelAndView之前执行
//应用场景从modelAndView出发，将公用的模型数据（比如菜单导航，在这里传到试图），也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("HandlerInterceptor...postHandle");
		
	}
//在handler之前执行，如果返回为false则拦截，不会执行handler
//用于身份认证，身份授权
//比如身份认证，如果认证通过，表示当前用户没有登陆，需要此方法拦截，不再往下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor...preHandle");
		return true;
	}

	

}

