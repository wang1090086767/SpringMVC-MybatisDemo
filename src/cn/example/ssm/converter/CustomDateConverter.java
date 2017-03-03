
package cn.example.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
类名：CustomDateConverter.java
创建人-->Wang JJ
创建时间：2017年3月3日下午2:14:53
description：Custom里时间的转化器，将字符串的时间转化为util包里的Date
*/
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
	//使用简单的Date格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		return 	format.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}

