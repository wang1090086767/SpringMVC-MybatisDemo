
package cn.example.ssm.exception;
/**
类名：CustomException.java
创建人-->Wang JJ
创建时间：2017年3月7日下午6:29:59
description：系统的预期异常，即自定义的异常，需要在程序中手动抛出异常
*/
public class CustomException extends Exception {
	/**
	 * serialVersionUID
	 *description：
	 *2017年3月7日下午6:30:47
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public CustomException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

