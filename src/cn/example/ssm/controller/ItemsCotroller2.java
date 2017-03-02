
package cn.example.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import cn.example.ssm.po.Items;

/**
类名：ItemsCotroller2.java
创建人-->Wang JJ
创建时间：2017年3月1日下午9:22:28
description：实现HttpRequsetHander的处理器
*/
public class ItemsCotroller2 implements HttpRequestHandler {

	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
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
				
				arg0.setAttribute("itemsList",itemsList);
				arg0.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(arg0, arg1);

				//使用此方法可以通过修改response，设置响应的数据格式，比如响应json数据

				/*
						response.setCharacterEncoding("utf-8");
						response.setContentType("application/json;charset=utf-8");
						response.getWriter().write("json串");*/

	}


	

	

}

