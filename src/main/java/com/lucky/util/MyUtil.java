package com.lucky.util;

import java.util.Collection;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lucky.config.MyConfiguration;
import com.lucky.services.ItemServiceLocal;

public class MyUtil {
 
	public static void main(String arg[]){
		ApplicationContext context  =  new AnnotationConfigApplicationContext(MyConfiguration.class);
		ItemServiceLocal service = context.getBean(ItemServiceLocal.class);
		
		service.getAll();
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}

	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object o) {
		if (o == null || (o instanceof Long && (Long)o == 0L)) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Collection<?> o) {
		if (o == null || o.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(StringBuffer sb) {
		if (sb == null || sb.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(StringBuilder sb) {
		if (sb == null || sb.length() == 0) {
			return true;
		}
		return false;
	}
} 
