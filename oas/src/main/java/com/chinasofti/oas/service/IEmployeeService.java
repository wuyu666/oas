package com.chinasofti.oas.service;

import java.util.List;

import com.chinasofti.oas.bean.Employee;
import com.chinasofti.oas.bean.Pages;

public interface IEmployeeService {
	/**
	 * 查询员工
	 * @param employee
	 * @return
	 */
	void queryEmployee(Pages<Employee> page);

	/**
	 * 修改员工信息
	 * @param page
	 * @return
	 */
	boolean updateEmployee(Employee employee);
	/**
	 * 添加员工
	 * @param page
	 * @return
	 */
	boolean insertEmployee(Employee employee);
	/**
	 * 删除员工
	 * @param page
	 * @return
	 */
	boolean deleteEmployee(int[] ids);
	
}
