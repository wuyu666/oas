package com.chinasofti.oas.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String patterns="yyyy-MM-dd HH:mm:ss";
	
	public static Date str2Date(String str){
		if(str == null || str.equals("")){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(patterns);
			try {
				return	sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	public static Date str2Date(String str,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			return	sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String date2Str(Date date){
		if(date == null ){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(patterns);
			
		return sdf.format(date);
	}
	
	public static String date2Str(Date date,String pattern){
		if(date == null ){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
			
		return sdf.format(date);
	}
}
