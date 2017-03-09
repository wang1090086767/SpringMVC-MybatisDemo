
package cn.example.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
类名：LoginInterceptor.java
创建人-->Wang JJ
创建时间：2017年3月9日下午3:34:20
description：识别用户身份信息的拦截器
*/
public class LoginInterceptor implements  HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
//进入Handler方法之前执行
	//用于身份认证/身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，则需要此方法拦截，不往下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		//获取请求的url
		String url = arg0.getRequestURI();
		//判断url是否公开地址（实际使用时将公开地址配置到配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action")>=0){
			//如果进行登陆提交，放行
			return true;
			
		}
		//判断session
		HttpSession session = arg0.getSession();
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		if(username!=null){
			//身份存在，放行
			return true;
		}
		//执行到这里表示用户身份需要认证，跳转登录页面
		arg0.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(arg0, arg1);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		
		return false;
	}

	

}

