
package cn.example.ssm.po;

import javax.validation.Valid;

/**
类名：UserVo.java
创建人-->Wang JJ
创建时间：2017年3月15日上午9:08:37
description：包装pojo
*/
public class UserVo {
@Valid
	private UserCustom userCustom;
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	@Valid
	private UserLogin userLogin;

}

