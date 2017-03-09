
package cn.example.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.example.ssm.mapper.UserCustomMapper;
import cn.example.ssm.po.UserCustom;
import cn.example.ssm.service.UserService;

/**
类名：UserServiceImpl.java
创建人-->Wang JJ
创建时间：2017年3月9日下午8:23:28
description：userService的实现类
*/
public class UserServiceImpl implements UserService {
  @Autowired
  private UserCustomMapper userCustomMapper;
  //通过用户名密码查询用户
	@Override
	public void findUserByUsernamePassword(UserCustom userCustom) throws Exception {
		userCustomMapper.findUserByUsernamePassword(userCustom);
		
	}
	
	//通过用户名查询用户
	@Override
	public void findUserByUsername(UserCustom userCustom) throws Exception {
		
	}


}

