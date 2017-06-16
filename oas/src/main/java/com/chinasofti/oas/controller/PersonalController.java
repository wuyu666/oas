package com.chinasofti.oas.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.oas.bean.Personal;
import com.chinasofti.oas.service.IPersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private IPersonalService personalService;
    @RequestMapping("/query")
    @ResponseBody
      public ModelAndView query(HttpServletRequest request,Personal personal){
    	List<Personal> list=personalService.query(personal);
    	ModelAndView personalQuery=new ModelAndView();
    	personalQuery.addObject("list", list);
    	
    	return personalQuery;
    }
}
