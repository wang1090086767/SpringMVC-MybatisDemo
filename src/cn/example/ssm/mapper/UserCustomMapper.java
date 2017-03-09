
package cn.example.ssm.mapper;

import cn.example.ssm.po.UserCustom;

/**
类名：UserCustomMapper.java
创建人-->Wang JJ
创建时间：2017年3月9日下午8:28:50
description：User的扩展类的Mapper
*/
public interface UserCustomMapper {
//通过用户名和密码验证用户
	public UserCustom findUserByUsernamePassword(UserCustom userCustom)throws Exception;

	//通过用户名查询用户
	public UserCustom findUserByUsername(String username)throws Exception;
}

