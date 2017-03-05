
package cn.example.ssm.po;

import java.util.List;

/**
类名：ItemsQueryVo.java
创建人-->Wang JJ
创建时间：2017年3月2日下午8:23:23
description：
*/
public class ItemsQueryVo {
	//商品信息类
	private Items items;
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
		//商品的扩展类
	private ItemsCustom itemsCustom;

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	//用于批量操作商品表的list
	private List<ItemsCustom> itemsList;
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

}

