
package cn.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;
import cn.example.ssm.service.ItemsService;
import cn.example.ssm.validategroup.ValidGroup1;

/**
 * 类名：ItemsCotroller2.java 创建人-->Wang JJ 创建时间：2017年3月1日下午9:22:28
 * description：使用注解来开发handler
 */
@Controller
/**
 * @RequestMapping 1、url映射 定义controller方法对应的url，进行处理器映射使用。 2、窄化映射
 *                 对url进行分类管理，可以在这里定义根路径，最终访问的路径是根路径加子路径 3、限制http请求方法
 *                 出于安全性考虑，对http的链接进行方法限制。method枚举属性
 *                 method={RequestMethod.GET,RequestMethod.POST}
 */
@RequestMapping("/items")
public class ItemsCotroller {
	// 通过注入的方式得到Service接口
	@Autowired
	private ItemsService itemsService;

	// //商品查询
	// @RequestMapping(value="queryItems",method={RequestMethod.GET,RequestMethod.POST})
	// public ModelAndView queryItems()throws Exception{
	// //调用Service查找数据库，查询商品列表
	// List<ItemsCustom> itemsList= itemsService.findItemsList(null);
	//
	// ModelAndView modelAndView = new ModelAndView();
	// //相当于requset的setAttribute，在jsp页面中通过itemList取数据
	// modelAndView.addObject("itemsList",itemsList);
	// //指定试图
	// modelAndView.setViewName("items/itemsList");
	// return modelAndView;
	// }
	// //商品查询
	// 使用包装的pojo来接收参数
	@RequestMapping(value = "queryItems", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryItems(Model model, HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		// 调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		// 通过形参中的model将model数据传到页面
		// 相当于modelAndeView.addObjcet方法
		model.addAttribute("itemsList", itemsList);
		// controller的方法返回string表示返回逻辑试图名
		return "items/itemsList";
	}

	// //商品信息修改页面显示
	// @RequestMapping("/editItems")
	// public ModelAndView editItems()throws Exception{
	//
	// //调用service根据商品id查询商品信息
	// ItemsCustom itemsCustom = itemsService.findItemsById(1);
	//
	// //返回ModelAndView
	// ModelAndView modelAndView = new ModelAndView();
	//
	// //相当于requset的setAttribute，在jsp页面中通过itemList取数据
	// modelAndView.addObject("itemsCustom",itemsCustom);
	//
	// //指定试图
	// modelAndView.setViewName("items/editItems");
	//
	// return modelAndView;
	// }
	// 商品信息修改页面显示
	@RequestMapping("/editItems")
	public String editItems(Model model, @RequestParam(value = "id", required = true) Integer items_id)
			throws Exception {

		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}

	// 商品信息修改提交
	// 使用校验器必须在需要校验的pojo参数前面加Validated,在形参中还得加bingResult，这两个成对存在，缺一不可
	//value={validGroup1.class}指定使用ValidGroup1的分组校验
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) Integer id, @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,
			BindingResult bindingResult) throws Exception {

		// 获取错误校验信息
		if (bindingResult.hasErrors()) {
			// 得到储存error的list集合
			List<ObjectError> allError = bindingResult.getAllErrors();
			// 遍历error信息
			for (ObjectError error : allError) {
				System.out.println(error.getDefaultMessage()+"---");
			}
			// 将错误信息显示到页面上
			model.addAttribute("allError", allError);
			
			return "items/editItems";

		}
			// 调用service更新商品信息，页面需要将商品信息传到此方法
			itemsService.updateItems(id, itemsCustom);

			// 重定向，地址栏改变
			// return "redirect:queryItems.action";
			// 页面转发，地址栏的url不变
			return "forward:queryItems.action";
	
	}

	// 批量删除商品
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_Id) throws Exception {
		// 删除商品
		itemsService.deleteItems(items_Id);

		return "forward:queryItems.action";
	}

	// 查询到商品的批量信息
	@RequestMapping("editItemsQuery")
	public String editItemsQuery(Model model, ItemsQueryVo itemsQueryVo) throws Exception {

		// 调用Service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 通过形参中的model将model数据传到页面

		// 相当于modelAndeView.addObjcet方法
		model.addAttribute("itemsList", itemsList);

		return "items/editItemsList";
	}

	// 批量修改商品提交
	// 通过ItemsQueryVo接收批量提交的商品，将商品信息存储到itemsQueryVo中itemsList属性中
	@RequestMapping("editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {

		// 得到批量修改后的商品信息
		// 。。。。。
		// 修改到数据库
		itemsService.updateAllItems(itemsQueryVo);

		return "forward:queryItems.action";
	}

}
