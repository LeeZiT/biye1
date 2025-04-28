package com.entity.view;

import com.entity.DiscussyouxiuzuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 优秀作品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
@TableName("discussyouxiuzuopin")
public class DiscussyouxiuzuopinView  extends DiscussyouxiuzuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyouxiuzuopinView(){
	}
 
 	public DiscussyouxiuzuopinView(DiscussyouxiuzuopinEntity discussyouxiuzuopinEntity){
 	try {
			BeanUtils.copyProperties(this, discussyouxiuzuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
