
package cn.example.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.example.ssm.po.Items;

/**
类名：ItemsCotroller2.java
创建人-->Wang JJ
创建时间：2017年3月1日下午9:22:28
description：使用注解来开发handler
*/
@Controller
public class ItemsCotroller3  {
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems()throws Exception{
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
				List<Items> itemsList = new ArrayList<Items>();
				//向list中填充静态数据
				Items items_1 = new Items();
				items_1.setName("联想笔记本");
				items_1.setPrice(6000f);
				items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
				
				Items items_2 = new Items();
				items_2.setName("苹果手机");
				items_2.setPrice(5000f);
				items_2.setDetail("iphone6苹果手机！");
				
				itemsList.add(items_1);
				itemsList.add(items_2);
				//返回ModelAndView
				ModelAndView modelAndView = new ModelAndView();
				//相当于requset的setAttribute，在jsp页面中通过itemList取数据
				modelAndView.addObject("itemsList",itemsList);
				//指定试图
				modelAndView.setViewName("items/itemsList");
				return modelAndView;
		
	}


	

	

}

