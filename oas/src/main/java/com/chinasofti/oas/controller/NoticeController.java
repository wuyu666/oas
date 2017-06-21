package com.chinasofti.oas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.PageBean;
import com.chinasofti.oas.service.INoticeService;

import com.chinasofti.oas.utils.ResponseUtil;
import com.chinasofti.oas.utils.Result;
import com.chinasofti.oas.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource	
	private INoticeService noticeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	/**
	 * 查询公告
	 * @param page
	 * @param rows
	 * @param no
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doSelect")
	public String doSelect(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,Notice no,HttpServletResponse res) throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nrange", StringUtil.formatLike(no.getNrange()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Notice> noList=noticeService.queryNotice(map);
        long total=noticeService.queryCount(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(noList);
        result.put("rows", jsonArray);
        result.put("total", total);
        
        System.out.println(noList.toString());
        System.out.println(total);
        ResponseUtil.write(res, result);
        return null;
    }
	/**
	 * 添加或修改公告
	 * @param no
	 * @param res
	 * @return
	 * @throws Exception
	 */
//	 @RequestMapping("/save")
//	    public String save(Notice no,HttpServletResponse res) throws Exception{
//	        //操作记录条数，初始化为0
//		 System.out.println("no="+no.toString());
//	        int resultTotal = 0;
//	        if (no.getNid() == null) {
//	        	System.out.println("id1="+no.getNid());
//	            resultTotal = noticeService.add(no);
//	        }else{
//	        	System.out.println("id2="+no.getNid());
//	            resultTotal = noticeService.update(no);
//	        }
//	        JSONObject jsonObject = new JSONObject();
//	        if(resultTotal > 0){   //说明修改或添加成功
//	            jsonObject.put("success", true);
//	        }else{
//	            jsonObject.put("success", false);
//	        }
//	        ResponseUtil.write(res, jsonObject);
//	        return null;
//	    }
	@RequestMapping("/add")
	@ResponseBody
	public Result add(Notice no){
		boolean flag=noticeService.add(no);
		Result result=new Result();
		if(flag){
			result.setStatus(1);
			result.setTip("添加成功");
		}else{
			result.setStatus(0);
			result.setTip("添加失败");
		}
			
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public Result update(Notice no){
		boolean flag=noticeService.update(no);
		Result result=new Result();
		if(flag){
			result.setStatus(1);
			result.setTip("修改成功");
		}else{
			result.setStatus(0);
			result.setTip("修改失败");
		}
			
		return result;
	}
	 /**
	  * 删除公告
	  * @param ids
	  * @param res
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/delete")
	    public String delete(@RequestParam(value="ids") String ids,HttpServletResponse res) throws Exception{
	        String[] idStr = ids.split(",");
	        JSONObject jsonObject = new JSONObject();
	        
	        for (String id : idStr) {
	        	System.out.println(id);
	        	noticeService.delete(Integer.parseInt(id));
	        }
	        jsonObject.put("success", true);
	        ResponseUtil.write(res, jsonObject);
	        return null;
	    }
}
