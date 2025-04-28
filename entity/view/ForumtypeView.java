package com.entity.view;

import com.entity.ForumtypeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 交流互动类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
@TableName("forumtype")
public class ForumtypeView  extends ForumtypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ForumtypeView(){
	}
 
 	public ForumtypeView(ForumtypeEntity forumtypeEntity){
 	try {
			BeanUtils.copyProperties(this, forumtypeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
