package com.chinasofti.oas.mapper;

import java.util.List;

import com.chinasofti.oas.bean.Rights;

public interface IRightMapper {
	
	/**
	 * 权限增加Dao层
	 */
	int insertRight(Rights right);
	
	/**
	 * 权限增加Dao层
	 */
	List<Rights> queryRight(Rights right);
	
	/**
	 * 权限更改，需要更改相关人员的权限
	 */
	int updateRight(Rights right);
	
	/**
	 * 权限删除，需要更改相关人员的权限
	 */
	int deleteRight(int[] right);
}
