package com.entity.view;

import com.entity.ZiliaoleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 资料类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@TableName("ziliaoleixing")
public class ZiliaoleixingView  extends ZiliaoleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiliaoleixingView(){
	}
 
 	public ZiliaoleixingView(ZiliaoleixingEntity ziliaoleixingEntity){
 	try {
			BeanUtils.copyProperties(this, ziliaoleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
