
package cn.example.ssm.validategroup;
/**
类名：ValidGroup1.java
创建人-->Wang JJ
创建时间：2017年3月7日下午2:17:43
description：在pojo中定义校验规则，而pojo是被多个controller所公用，当不同的controller方法对同一个pojo进行校验
	但每个controller方法需要不同的校验
	解决方法：
	定义多个校验分组（一个java接口），分组中定义有规则，每个controller1方法使用不同的校验分组
	校验分组1
*/
public interface ValidGroup1 {
//接口中不需要定义任何方法，仅对不同的校验规则进行分组
//此分组值校验商品名称长度
	

}

