
package cn.example.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.example.ssm.po.ItemsCustom;

/**
类名：JsonTest.java
创建人-->Wang JJ
创建时间：2017年3月9日上午10:47:49
description：json交互测试
*/
@Controller
public class JsonTest {

	//请求json串（商品信息），输出json（商品信息）
	//@ResquestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requsetJson(@RequestBody ItemsCustom itemsCustom)throws Exception{
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;
		
	}
	//请求Key/value,输出json
	//不需要@RequestBody
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom)throws Exception{
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;
		
	}
	
}

