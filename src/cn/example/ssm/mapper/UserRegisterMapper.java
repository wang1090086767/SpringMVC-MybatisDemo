
package cn.example.ssm.mapper;

import cn.example.ssm.po.UserVo;

/**
类名：UserRegisterMapper.java
创建人-->Wang JJ
创建时间：2017年3月15日上午9:10:34
description：user注册的Mapper
*/
public interface UserRegisterMapper {
	
	public Integer insertUser(UserVo userVo) throws Exception;
	public Integer insertUserLogin(UserVo userVo) throws Exception;
	

}

