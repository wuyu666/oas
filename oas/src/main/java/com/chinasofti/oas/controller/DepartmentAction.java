package com.chinasofti.oas.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.oas.bean.Department;
import com.chinasofti.oas.service.IDepartmentService;

/**
 * 部门Action
 * @author wy
 * 2017年6月15日
 */
@Controller
@RequestMapping("/department")
public class DepartmentAction {
	@Resource
	private IDepartmentService departmentService;
	/**
	 * 查询操作
	 * @param department
	 * @return
	 */
	@RequestMapping("/doQuery")
	@ResponseBody
	public List<Department> doQuery(Department department){
		List<Department> list=departmentService.queryDepartment(department);
		return list;
	}
	/**
	 * 添加操作
	 * @param department
	 * @return
	 */
	@RequestMapping("/doInsert")
	public boolean doInsert(Department department){
		boolean flag=departmentService.insertDepartment(department);
		return flag;
	}
	/**
	 * 去往修改页面
	 * @param department
	 * @return
	 */
	@RequestMapping("/toUpdate")
	@ResponseBody
	public String toUpdate(int id){
		departmentService.queryDepartmentById(id);
		return "toUpdate";
	}
	/**
	 * 修改操作
	 * @param department
	 * @return
	 */
	@RequestMapping("/doUpdate")
	public boolean doUpdate(Department department){
		boolean flag=departmentService.updateDepartment(department);
		return flag;
	}
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping("/doDelete")
	public boolean doDelete(int id){
		boolean flag=departmentService.deleteDepartment(id);
		return flag;
	}
}
