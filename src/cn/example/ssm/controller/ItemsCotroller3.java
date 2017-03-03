
package cn.example.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.example.ssm.po.Items;
import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.service.ItemsService;

/**
类名：ItemsCotroller2.java
创建人-->Wang JJ
创建时间：2017年3月1日下午9:22:28
description：使用注解来开发handler
*/
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url的是根路径+子路径
//比如/items/queryItems
public class ItemsCotroller3  {
	//通过注入的方式得到Service接口
	@Autowired
	private ItemsService itemsService;
	
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems()throws Exception{
	//调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList= itemsService.findItemsList(null);
		
				ModelAndView modelAndView = new ModelAndView();
				//相当于requset的setAttribute，在jsp页面中通过itemList取数据
				modelAndView.addObject("itemsList",itemsList);
				//指定试图
				modelAndView.setViewName("items/itemsList");
				return modelAndView;	
	}
	
	//商品信息修改页面显示
	@RequestMapping("/editItems")
	public ModelAndView editItems()throws Exception{
	
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//相当于requset的setAttribute，在jsp页面中通过itemList取数据
		modelAndView.addObject("itemsCustom",itemsCustom);
		
		//指定试图
		modelAndView.setViewName("items/editItems");
		
		return modelAndView;
	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit()throws Exception{
	
		
	ModelAndView modelAndView = new ModelAndView();
		
		//相当于requset的setAttribute，在jsp页面中通过itemList取数据
		
		
		//指定试图
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	

	

	

}
