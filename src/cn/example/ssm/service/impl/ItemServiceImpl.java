
package cn.example.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.example.ssm.mapper.ItemsMapperCustom;
import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;
import cn.example.ssm.service.ItemsService;

/**
类名：ItemServiceImpl.java
创建人-->Wang JJ
创建时间：2017年3月2日下午8:33:16
description：实现ItemsService
*/
public class ItemServiceImpl  implements ItemsService{
	//通过注入调用持久层的Mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//返回Mapper的查询数据
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	

}

