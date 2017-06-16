package com.chinasofti.oas.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Service;

import com.chinasofti.oas.bean.Personal;
import com.chinasofti.oas.mapper.PersonalMapper;
import com.chinasofti.oas.service.IPersonalService;
@Service("personalServiceImpl")
public class PersonalServiceImpl implements IPersonalService {
	@Resource
	private	PersonalMapper personalMapper;
	@Override
	public List<Personal> query(Personal personal) {
		
		return personalMapper.query(personal);
	}
   
	
	
	

}
