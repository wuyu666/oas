package com.chinasofti.oas.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class Date2JsonValueProcessor implements JsonValueProcessor{
	private String patterns="yyyy-MM-dd HH:mm:ss";
	
	
	public Date2JsonValueProcessor() {		
	}

	public Date2JsonValueProcessor(String patterns) {		
		this.patterns = patterns;
	}

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		if(value==null){
			
			return "";
		}
		if(value instanceof Date){
			String str=new SimpleDateFormat(patterns).format((Date)value);
			
			return str;
		}
		return value.toString();
	}

}
