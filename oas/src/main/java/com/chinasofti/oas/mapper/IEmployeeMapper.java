package com.chinasofti.oas.mapper;

import java.util.List;

import com.chinasofti.oas.bean.Employee;
import com.chinasofti.oas.bean.Pages;

public interface IEmployeeMapper {
	/**
	 * 查询员工
	 * @param employee
	 * @return
	 */
	List<Employee> queryEmployee(Pages<Employee> page);
	/**
	 * 查询员工数量
	 * @param page
	 * @return
	 */
	int queryCount(Pages<Employee> page);
	/**
	 * 修改员工信息
	 * @param page
	 * @return
	 */
	int updateEmployee(Employee employee);
	/**
	 * 添加员工
	 * @param page
	 * @return
	 */
	int insertEmployee(Employee employee);
	/**
	 * 删除员工
	 * @param page
	 * @return
	 */
	int deleteEmployee(int[] ids);
	
}
