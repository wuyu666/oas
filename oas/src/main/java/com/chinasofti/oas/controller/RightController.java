package com.chinasofti.oas.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.chinasofti.oas.bean.Rights;
import com.chinasofti.oas.service.IRightService;
import com.chinasofti.oas.utils.ResponseUtil;
import com.chinasofti.oas.utils.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 权限管理类
 * @author 曾欢
 * 2017年6月15日
 */
@Controller
@RequestMapping("/right")
public class RightController {
	@Resource	
	private IRightService rightService;
	
	/**
	 * 增加权限
	 * @param right
	 */
	@RequestMapping("/doInsert")
	@ResponseBody
	public Result doInsert(Rights right){
		System.out.println("controller执行插入方法");
		int b=rightService.insertRight(right);
		Result result=new Result();
        if (b>0) {
      	  result.setStatus(0);
			  result.setTip("插入成功");
		}else {
			  result.setStatus(1);
			  result.setTip("插入失败");
		}
		return result;
	}
	/**
	 * 权限查询，需要查询人员的相关权限
	 * @param right	
	 * @throws IOException 
	 */
	@RequestMapping("/doQuery")
	@ResponseBody
	public List<Rights> doQuery(Rights right,HttpServletResponse resp) throws IOException{
		List<Rights> list = rightService.queryRight(right);
		System.out.println("controller执行查询方法");
		return list;
	}

	
	/** 
     * @param request 
     * @return 
     * 更新数据 
     */  
    @RequestMapping("/doUpdate")  
    @ResponseBody
    public Result doUpdate(Rights right)  
    {  
    	System.out.println("controller执行更新方法");
        int b=rightService.updateRight(right);
        Result result=new Result();
          if (b>0) {
        	  result.setStatus(0);
  			  result.setTip("修改成功");
		}else {
			  result.setStatus(1);
			  result.setTip("修改失败");
		}
        return result;
    }  
	/**
	 * 权限删除，需要删除
	 * @param right
	 */
	@RequestMapping("/doDelete")
	@ResponseBody//这个注解表示返回一个json格式
	 public Result doDelete(int[] right)
    {  
		System.out.println("right值"+Arrays.toString(right));
    	System.out.println("controller执行删除方法");
        boolean b=rightService.deleteRight(right);
        Result result=new Result();
          if (b) {
        	  result.setStatus(0);
  			  result.setTip("删除成功");
		}else {
			  result.setStatus(1);
			  result.setTip("删除失败");
		}
        return result;
    }  
}
