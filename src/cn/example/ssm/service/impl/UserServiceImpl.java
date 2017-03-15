
package cn.example.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.example.ssm.exception.CustomException;
import cn.example.ssm.mapper.UserLoginMapper;
import cn.example.ssm.mapper.UserRegisterMapper;
import cn.example.ssm.po.UserLogin;
import cn.example.ssm.po.UserVo;
import cn.example.ssm.service.UserService;

/**
类名：UserServiceImpl.java
创建人-->Wang JJ
创建时间：2017年3月9日下午8:23:28
description：userService的实现类
*/
public class UserServiceImpl implements UserService {
  @Autowired
  private UserLoginMapper loginMapper;
  @Autowired
  private UserRegisterMapper userRegisterMapper;
  
  //通过用户名密码查询用户
	@Override
	public Integer findUserByUsernamePassword(UserLogin userLogin) throws Exception {
		if(userLogin!=null){		
			int record= loginMapper.findUserByUsernamePassword(userLogin);
			return record;
		}
		return 0;
	}
	
	//通过用户名查询用户
	@Override
	public Integer findUserByUsername(UserLogin userLogin) throws Exception {
		int record = 0;
		record = loginMapper.findUserByUsername(userLogin);
		
		return record;
	}
	//插入用户注册信息
	@Override
	public Integer insertUserAndUserLogin(UserVo userVo) throws Exception {
		int record1 = 0;
		int record2 = 0;
		int record = 0;
		
		if(userVo.getUserLogin()!=null){
	//先插入有主建的表，然后插入没有主键的表
		record1 = userRegisterMapper.insertUser(userVo);
		record2 = userRegisterMapper.insertUserLogin(userVo);
		
		}
		record = record1+record2;
		if(record!=2){
			throw new CustomException("注册失败");
		}
		
		return record1;
	}


}

