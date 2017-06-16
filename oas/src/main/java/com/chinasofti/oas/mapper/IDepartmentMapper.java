package com.chinasofti.oas.mapper;

import java.util.List;

import com.chinasofti.oas.bean.Department;

/**
 * 部门Mapper接口
 * @author wy
 * 2017年6月15日
 */

public interface IDepartmentMapper {
	/**
	 * 查询所有部门
	 * @param department
	 * @return
	 */
	List<Department> queryDepartment(Department department);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Department queryDepartmentById(int id);
	/**
	 * 修改部门
	 * @param department
	 * @return
	 */
	boolean updateDepartment(Department department);
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	boolean insertDepartment(Department department);
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	boolean deleteDepartment(int id);
}
