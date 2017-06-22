package com.chinasofti.oas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.bean.Employee;
import com.chinasofti.oas.bean.Pages;
import com.chinasofti.oas.mapper.IEmployeeMapper;
import com.chinasofti.oas.service.IEmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService{
	@Resource
	private IEmployeeMapper employeeMapper;
	@Override
	public void queryEmployee(Pages<Employee> page) {
		List<Employee> list=employeeMapper.queryEmployee(page);
		int total=employeeMapper.queryCount(page);
		page.setRows(list);
		page.setTotal(total);
	}
	@Override
	public boolean updateEmployee(Employee employee) {
		int row=employeeMapper.updateEmployee(employee);
		if(row>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean insertEmployee(Employee employee) {
		int row=employeeMapper.insertEmployee(employee);
		if(row>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteEmployee(int[] ids) {
		int row=employeeMapper.deleteEmployee(ids);
		if(row>0){
			return true;
		}
		return false;
	}
}
