
package cn.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;
import cn.example.ssm.service.ItemsService;

/**
类名：ItemsCotroller2.java
创建人-->Wang JJ
创建时间：2017年3月1日下午9:22:28
description：使用注解来开发handler
*/
@Controller
/**
 * @RequestMapping
 * 1、url映射
 * 定义controller方法对应的url，进行处理器映射使用。
 * 2、窄化映射
 * 对url进行分类管理，可以在这里定义根路径，最终访问的路径是根路径加子路径
 * 3、限制http请求方法
 * 出于安全性考虑，对http的链接进行方法限制。method枚举属性
 * method={RequestMethod.GET,RequestMethod.POST}
 */
@RequestMapping("/items")
public class ItemsCotroller  {
	//通过注入的方式得到Service接口
	@Autowired
	private ItemsService itemsService;
	
//	//商品查询
//	@RequestMapping(value="queryItems",method={RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView queryItems()throws Exception{
//	//调用Service查找数据库，查询商品列表
//		List<ItemsCustom> itemsList= itemsService.findItemsList(null);
//		
//				ModelAndView modelAndView = new ModelAndView();
//				//相当于requset的setAttribute，在jsp页面中通过itemList取数据
//				modelAndView.addObject("itemsList",itemsList);
//				//指定试图
//				modelAndView.setViewName("items/itemsList");
//				return modelAndView;	
//	}
//	//商品查询
	//使用包装的pojo来接收参数
	@RequestMapping(value="queryItems",method={RequestMethod.GET,RequestMethod.POST})
	public String  queryItems(Model model,HttpServletRequest request,ItemsQueryVo itemsQueryVo)throws Exception{
	//调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList= itemsService.findItemsList(itemsQueryVo);
		//通过形参中的model将model数据传到页面
		//相当于modelAndeView.addObjcet方法
		model.addAttribute("itemsList",itemsList);
		//controller的方法返回string表示返回逻辑试图名
		return "items/itemsList";
	}
	
	
//	//商品信息修改页面显示
//	@RequestMapping("/editItems")
//	public ModelAndView editItems()throws Exception{
//	
//		//调用service根据商品id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		//返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		
//		//相当于requset的setAttribute，在jsp页面中通过itemList取数据
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		
//		//指定试图
//		modelAndView.setViewName("items/editItems");
//		
//		return modelAndView;
//	}
	//商品信息修改页面显示
		@RequestMapping("/editItems")
		public String editItems(Model model,@RequestParam(value="id",required=true)Integer items_id)throws Exception{
		
			//调用service根据商品id查询商品信息
			ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
			model.addAttribute("itemsCustom",itemsCustom);
			
			return "items/editItems";
		}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,@RequestParam(value="id",required=true)Integer id,ItemsCustom itemsCustom)throws Exception{
	//调用service更新商品信息，页面需要将商品信息传到此方法
	itemsService.updateItems(id, itemsCustom);
	
		//重定向，地址栏改变
//		return "redirect:queryItems.action";
		//页面转发，地址栏的url不变
	return "forward:queryItems.action";
	}
	

	

	

}
