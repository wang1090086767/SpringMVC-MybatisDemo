
package cn.example.ssm.mapper;

import cn.example.ssm.po.UserCustom;
import cn.example.ssm.po.UserLogin;

/**
类名：UserLoginMapper.java
创建人-->Wang JJ
创建时间：2017年3月15日上午8:34:35
description：登陆的Mapper
*/
public interface UserLoginMapper {

	//通过用户名和密码验证用户
		public Integer findUserByUsernamePassword(UserLogin userLogin)throws Exception;

		//通过用户名查询用户
		public Integer findUserByUsername(UserLogin userLogin)throws Exception;

}

