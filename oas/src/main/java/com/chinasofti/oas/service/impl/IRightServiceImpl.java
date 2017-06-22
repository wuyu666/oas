package com.chinasofti.oas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.bean.Rights;
import com.chinasofti.oas.mapper.IRightMapper;
import com.chinasofti.oas.service.IRightService;
@Service("rightService")
public class IRightServiceImpl implements IRightService{
	
	@Resource
	private IRightMapper rightMapper;
	/**
	 * 增加权限
	 * @param right
	 */
	@Override
	public int insertRight(Rights right) {
		System.out.println("service执行插入方法");
		int flag = rightMapper.insertRight(right);
		return flag;
	}
	/**
	 * 查询权限实现类
	 * @param right
	 */
	@Override
	public List<Rights> queryRight(Rights right) {
		List<Rights> list = rightMapper.queryRight(right);
		return list;
	}
	/**
	 * 更新权限实现类
	 * @param right
	 */
	@Override
	public int updateRight(Rights right) {
		System.out.println("service执行更新方法");
		int flag = rightMapper.updateRight(right);
		return flag;
	}
	/**
	 * 删除权限实现类
	 * @param right
	 */
	@Override
	public boolean deleteRight(int[] right) {
		System.out.println("service执行删除方法");
		int rows = rightMapper.deleteRight(right);
		System.out.println("rows值为"+rows);
		if (rows>0){ 
			return true;
		}else {
			return false;
		}
		
	}
	

}
