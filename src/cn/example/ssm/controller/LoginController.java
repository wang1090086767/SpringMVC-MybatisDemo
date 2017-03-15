
package cn.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.example.ssm.po.UserCustom;
import cn.example.ssm.po.UserLogin;
import cn.example.ssm.po.UserVo;
import cn.example.ssm.service.UserService;
import cn.example.ssm.validategroup.RegisterValidGroup;

/**
类名：LoginController.java
创建人-->Wang JJ
创建时间：2017年3月9日下午3:26:44
description：处理用户登录的Handler
*/
@Controller
public class LoginController {
  
  @Autowired
  private UserService userService;
	//登陆
	@RequestMapping("/login")
	public String login(Model model,HttpSession session,String login_name,String login_password)throws Exception{
		//调用service进行用户身份认证
		//。。。。
		UserLogin userLogin = new UserLogin();
		userLogin.setLogin_name(login_name);
		userLogin.setLogin_password(login_password);
		
		//先根据用户名查询用户信息，如果没有则返回
		int username_record = userService.findUserByUsername(userLogin);
		if(username_record==0){
			model.addAttribute("login_err","用户名不存在");
			return "login";
		}
		//从数据库中查询用户名和密码
		int record = userService.findUserByUsernamePassword(userLogin);
		if(record==1){
		//在session中保存用户身份信息
		session.setAttribute("username", login_name);
		//重定向到商品页面
				return "redirect:/items/queryItems.action";
		}
		else{
			//当没查询到用户信息返回
			model.addAttribute("login_err","用户名或密码错误");
			return "login";
		}
		
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		//移除session里的用户身份信息
		session.invalidate();
		
		//重定向到商品界面
		return "redirect:/items/queryItems.action";
	}
	
	//注册
	@RequestMapping("/register")
	public String register(Model model,HttpServletRequest request,@Validated(value={RegisterValidGroup.class}) UserVo userVo,BindingResult bindingResult)throws Exception{
		//当做跳转注册页面，没有参数时
				if(userVo.getUserLogin()==null){
				 return "register";
				}
		//打印错误信息
		if(bindingResult.hasErrors()){
			//得到错误信息的集合
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			System.out.println(allErrors);
			//将错误信息传到页面
			model.addAttribute("allError",allErrors);
			return "register";
		}
		
		
		//查找用户名是否存在
		int username_record = userService.findUserByUsername(userVo.getUserLogin());
		//如果用户名已经存在则返回
		if(username_record==1){
			
			model.addAttribute("register_err","用户名已存在");
			return "register";
		}
		
		//没有用户信息则插入信息，则注册成功
		 userService.insertUserAndUserLogin(userVo);	
	  model.addAttribute("register_success","注册成功！");
	   return "login";
  
		

	}
	

}

