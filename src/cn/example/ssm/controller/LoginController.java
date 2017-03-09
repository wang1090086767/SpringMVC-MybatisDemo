
package cn.example.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
类名：LoginController.java
创建人-->Wang JJ
创建时间：2017年3月9日下午3:26:44
description：处理用户登录的Handler
*/
@Controller
public class LoginController {
  
  
	//登陆
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password)throws Exception{
		//调用service进行用户身份认证
		//。。。。
		
		//在session中保存用户身份信息
		session.setAttribute("username", username);
		//重定向到商品页面
		return "redirect:/items/queryItems.action";
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		//移除session里的用户身份信息
		session.invalidate();
		
		//重定向到商品界面
		return "redirect:/items/queryItems.action";
	}
	

}

