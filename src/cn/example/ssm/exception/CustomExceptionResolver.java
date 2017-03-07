
package cn.example.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
类名：CustomExceptionResolver.java
创建人-->Wang JJ
创建时间：2017年3月7日下午6:33:56
description：配置springmvc的全局异常处理器
全局异常处理器处理思路：
		解析出异常类型
		如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示
		如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）

*/
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		//handler就是处理器适配器要执行Handler对象（只有method）
		//解析出异常类型
		//如果改异常类型是系统自定义的异常，直接取出异常信息，在错误页面中展示
//		String message = null;
//		if(arg3 instanceof CustomException){
//			message = arg3.getMessage();
//		}else{
//			//如果该异常类型不是系统自定义异常，则构造一个自定义的一场'未知错误'
//			message = "未知错误";
//		}
		//上边代码变为
		CustomException customException = null;
		if(arg3 instanceof CustomException){
			customException = (CustomException) arg3;
		}else{
			customException = new CustomException("未知错误");
		}
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		
		//指向错误页面 
		modelAndView.setViewName("error");
				return modelAndView;
	}

	

}

