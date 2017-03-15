
package cn.example.ssm.po;

import javax.validation.constraints.NotNull;

import cn.example.ssm.validategroup.RegisterValidGroup;

/**
类名：UserLogin.java
创建人-->Wang JJ
创建时间：2017年3月15日上午8:32:57
description：登陆信息的pojo
*/
public class UserLogin {
	private Integer id;
	@NotNull(message="{userLogin.login_name.isNull}",groups={RegisterValidGroup.class})
	private String login_name;
	@NotNull(message="{userLogin.login_password.isNull}",groups={RegisterValidGroup.class})
	private String login_password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	
	

}

