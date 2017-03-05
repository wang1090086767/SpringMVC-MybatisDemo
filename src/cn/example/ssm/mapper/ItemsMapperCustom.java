
package cn.example.ssm.mapper;

import java.util.List;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;

/**
类名：ItemsMapperCustom.java
创建人-->Wang JJ
创建时间：2017年3月2日下午8:17:44
description：查询商品列表
*/
public interface ItemsMapperCustom {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//删除商品信息
	public void deleteItems(Integer[] items_Id) throws Exception;
	/**
	 * Title-->updateAllItems
	 *2017年3月5日上午10:40:46
	 *description：批量修改商品信息
	 *@param itemsQueryVo
	 *@throws Exception
	 */
	public void updateAllItems(ItemsQueryVo itemsQueryVo)throws Exception;
}

