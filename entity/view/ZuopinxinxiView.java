package com.entity.view;

import com.entity.ZuopinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作品信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@TableName("zuopinxinxi")
public class ZuopinxinxiView  extends ZuopinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuopinxinxiView(){
	}
 
 	public ZuopinxinxiView(ZuopinxinxiEntity zuopinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zuopinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
