
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

	//商品查询列表
		public List<ItemsCustom> findItemsList( ItemsQueryVo itemsQueryVo) throws Exception;
}

