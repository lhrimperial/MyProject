package com.handy.frame.server.database.assignment;

import com.handy.frame.server.context.UserContext;
import com.handy.frame.shared.constant.Constant;
import com.handy.frame.util.StringUtils;
import com.handy.frame.util.UUIDUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 实现对业务无关字段赋值
 * AssignmentAspect
 * @author 龙海仁
 * @create：2016年3月30日 下午6:24:13 
 */
@Aspect
@Component
public class AssignmentAspect {
	
	private static ThreadLocal<HashMap<String, Object>> keyWords = new ThreadLocal<HashMap<String, Object>>();
	
	@Before("execution(* com.*..*.mapper.*Mapper.insert*(..)) || execution(* com.*..*.mapper.*Mapper.update*(..)) ")
	public void assignmentValue(JoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		if(methodName.contains("insert")){
			insertValue();
		}else if(methodName.contains("update")){
			updateValue();
		}
		Object[] args = jp.getArgs();
		for(Object obj : args){
			if(obj instanceof List){
				List<?> list = (List<?>) obj;
				for(Object o : list){
					voluation(o);
				}
			}else{
				voluation(obj);
			}
		}
	}
	
	/**
	 * 对对象中的固有字段赋值
	 * @param obj
	 * @author 龙海仁
	 * @date 2016年4月29日下午3:56:54
	 * @update 
	 */
	public void voluation(Object obj){
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				//为空赋值
				ReflectionUtils.makeAccessible(field);
				if((field.get(obj) == null || field.get(obj) == "") && keyWords.get().containsKey(field.getName())){
					ReflectionUtils.setField(field, obj,keyWords.get().get(field.getName()));
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void updateValue(){
		HashMap<String, Object> map = keyWords.get();
		if(map == null){
			map = new HashMap<String, Object>();
			keyWords.set(map);
		}
		keyWords.get().clear();
		keyWords.get().put("modifyUser", getCurrentUserCode());
		keyWords.get().put("modifyTime", new Date());
		keyWords.get().put("versionNo", UUIDUtil.getVersion());
	}
	
	public void insertValue(){
		HashMap<String, Object> map = keyWords.get();
		if(map == null){
			map = new HashMap<String, Object>();
			keyWords.set(map);
		}
		keyWords.get().clear();
		keyWords.get().put("isDeleted", Constant.NOT_DELETED);
		keyWords.get().put("createUser", getCurrentUserCode());
		keyWords.get().put("createTime", new Date());
		keyWords.get().put("modifyUser", getCurrentUserCode());
		keyWords.get().put("modifyTime", new Date());
		keyWords.get().put("versionNo", UUIDUtil.getVersion());
	}
	
	
	public String getCurrentUserCode(){
		String userName = null;
		try {
			userName = UserContext.getCurrentUser().getUserName();
			if(StringUtils.isBlank(userName)){
				userName = "admin";
			}
		} catch (Exception e) {
			userName = "admin";
		}
		return userName;
 	}

}
