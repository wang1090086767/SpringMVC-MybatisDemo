
package cn.example.ssm.po;
/**
类名：UserVo.java
创建人-->Wang JJ
创建时间：2017年3月15日上午9:08:37
description：包装pojo
*/
public class UserVo {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	private UserLogin userLogin;

}

