package com.entity.view;

import com.entity.DiscussziyuankuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 资源库评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
@TableName("discussziyuanku")
public class DiscussziyuankuView  extends DiscussziyuankuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussziyuankuView(){
	}
 
 	public DiscussziyuankuView(DiscussziyuankuEntity discussziyuankuEntity){
 	try {
			BeanUtils.copyProperties(this, discussziyuankuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
