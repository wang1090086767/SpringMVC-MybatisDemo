
package cn.example.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.example.ssm.exception.CustomException;
import cn.example.ssm.mapper.ItemsMapper;
import cn.example.ssm.mapper.ItemsMapperCustom;
import cn.example.ssm.po.Items;
import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;
import cn.example.ssm.service.ItemsService;

/**
 * 类名：ItemServiceImpl.java 创建人-->Wang JJ 创建时间：2017年3月2日下午8:33:16
 * description：实现ItemsService
 */
public class ItemServiceImpl implements ItemsService {
	// 通过注入调用持久层的Mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	// 注入得到ItemsMapper
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 返回Mapper的查询数据
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		// 中间对商品信息进行业务处理
		// 。。。。。。
		// 返回ItemsCustom
		ItemsCustom itemsCustom = null;

	//判断商品是否存在
		if (items != null) {
			itemsCustom = new ItemsCustom();
			// spring提供的拷贝属性
			BeanUtils.copyProperties(items, itemsCustom);
		}else{
			throw new CustomException("商品不存在！");
		}
		return itemsCustom;
	}

	// 更新商品信息
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加业务校验，通常在Service接口对关键的参数进行校验
		// 校验id是否为空，为空则抛出异常
		if (id != null) {
			itemsCustom.setId(id);
			// 更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本类型字段
			itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		}
	}

	// 删除商品信息
	@Override
	public void deleteItems(Integer[] items_Id) throws Exception {
		//判断是否有id
		if(items_Id!=null){
		// 通过id删除商品信息
		itemsMapperCustom.deleteItems(items_Id);
		}

	}

	// 批量修改商品信息
	@Override
	public void updateAllItems(ItemsQueryVo itemsQueryVo) throws Exception {
		// 批量更改商品信息
		itemsMapperCustom.updateAllItems(itemsQueryVo);

	}
}
