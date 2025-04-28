package com.entity.view;

import com.entity.YouxiuzuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 优秀作品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@TableName("youxiuzuopin")
public class YouxiuzuopinView  extends YouxiuzuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouxiuzuopinView(){
	}
 
 	public YouxiuzuopinView(YouxiuzuopinEntity youxiuzuopinEntity){
 	try {
			BeanUtils.copyProperties(this, youxiuzuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
