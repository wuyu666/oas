package com.chinasofti.oas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.oas.bean.Employee;
import com.chinasofti.oas.bean.Pages;
import com.chinasofti.oas.service.IEmployeeService;
import com.chinasofti.oas.utils.Result;

/**
 * 员工Action
 * @author wy
 * 2017年6月20日
 */
@Controller
@RequestMapping("/employee")
public class EmployeeAction {
	@Resource
	private IEmployeeService employeeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	
	/**
	 * 查询操作
	 * @param employee
	 * @return
	 */
	@RequestMapping("/doQuery")
	@ResponseBody
	public Pages<Employee> doQuery(Employee employee,Integer curPage,Integer pageSize){
		System.out.println("000000000");
		Pages<Employee> page=new Pages<Employee>();
		page.setQuery(employee);
		if (curPage!=null) {
			page.setCurPage(curPage);
		}
		if(pageSize!=null){
			page.setPageSize(pageSize);
		}
		employeeService.queryEmployee(page);
		System.out.println("1111111111111");
		return page;
	}
	/**
	 * 修改操作
	 * @param employee
	 * @return
	 */
	@RequestMapping("/doUpdate")
	@ResponseBody
	public Result doUpdate(Employee employee){
		System.out.println("222222222");
		boolean flag=employeeService.updateEmployee(employee);
		Result result=new Result();
		if(flag){
			result.setStatus(1);
			result.setTip("修改成功");
		}else {
			result.setStatus(0);
			result.setTip("修改失败");
		}
		System.out.println("333333333");
		return result;
	}
	/**
	 * 添加操作
	 * @param employee
	 * @return
	 */
	@RequestMapping("/doInsert")
	@ResponseBody
	public Result doInsert(Employee employee){
		System.out.println("444444444");
		boolean flag=employeeService.insertEmployee(employee);
		Result result=new Result();
		if(flag){
			result.setStatus(1);
			result.setTip("添加成功");
		}else {
			result.setStatus(0);
			result.setTip("添加失败");
		}
		System.out.println("555555555555");
		return result;
	}
	/**
	 * 删除操作
	 * @param ids
	 * @return
	 */
	@RequestMapping("/doDelete")
	@ResponseBody
	public Result doDelete(int[] ids){
		System.out.println("6666666666666");
		boolean flag=employeeService.deleteEmployee(ids);
		Result result=new Result();
		if(flag){
			result.setStatus(1);
			result.setTip("删除成功");
		}else {
			result.setStatus(0);
			result.setTip("删除失败");
		}
		System.out.println("777777777");
		return result;
	}
}
