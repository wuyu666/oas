package com.chinasofti.oas.service;

import java.util.List;

import com.chinasofti.oas.bean.Rights;



public interface IRightService {
	/**
	 * 增加权限
	 */
	int insertRight(Rights right);
	
	/**
	 * 权限查询，需要查询相关人员
	 */
	List<Rights> queryRight(Rights right);
	
	/**
	 * 权限更改，需要更改相关人员的权限
	 */
	int updateRight(Rights right);
	/**
	 * 权限删除，删除相关人员的权限
	 */
	boolean deleteRight(int[] right);
	
}
