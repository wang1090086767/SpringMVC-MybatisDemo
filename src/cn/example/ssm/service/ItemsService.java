
package cn.example.ssm.service;

import java.util.List;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;

/**
类名：ItemsService.java
创建人-->Wang JJ
创建时间：2017年3月2日下午8:31:54
description：业务层 查询商品列表
*/
public interface ItemsService {


	/**
	 * Title-->findItemsList
	 *2017年3月3日上午10:08:38
	 *description：查询商品列表
	 *@param itemsQueryVo
	 *@return
	 *@throws Exception
	 */
		public List<ItemsCustom> findItemsList( ItemsQueryVo itemsQueryVo) throws Exception;
	//根据id查询商品信息
	/**
	 * Title-->findItemsById
	 *2017年3月3日上午10:09:56
	 *description：根据商品Id查询商品信息
	 *@param id
	 *@return
	 *@throws Exception
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;	
//修改商品信息
	/**
	 * Title-->updateItems
	 *2017年3月3日上午10:11:22
	 *description：
	 *@param id  修改商品id
	 *@param itemsCustom 修改商品信息
	 *@throws Exception
	 */
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	/**
	 * Title-->deleteItems
	 *2017年3月4日下午9:01:20
	 *description：根据Id删除商品
	 *@param items_Id
	 *@throws Exception
	 */
	public void deleteItems(Integer[] items_Id)throws Exception;
	

}

