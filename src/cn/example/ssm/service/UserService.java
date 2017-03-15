
package cn.example.ssm.service;

import cn.example.ssm.po.UserCustom;
import cn.example.ssm.po.UserLogin;
import cn.example.ssm.po.UserVo;

/**
类名：UserService.java
创建人-->Wang JJ
创建时间：2017年3月9日下午8:20:27
description：处理用户的业务需求
*/
public interface UserService {

	//判断用户名和密码
	public Integer findUserByUsernamePassword(UserLogin userLogin)throws Exception;
//通过用户名查询用户
	public Integer findUserByUsername(UserLogin userLogin)throws Exception;
	
	//注册插入用户数据
	public Integer insertUserAndUserLogin(UserVo userVo)throws Exception;
}

