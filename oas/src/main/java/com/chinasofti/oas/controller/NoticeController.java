package com.chinasofti.oas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.oas.bean.Notice;
import com.chinasofti.oas.bean.PageBean;
import com.chinasofti.oas.service.INoticeService;
import com.chinasofti.oas.utils.ResponseUtil;
import com.chinasofti.oas.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource	
	private INoticeService noticeService;
	
	
	@RequestMapping("/doSelect")
	@ResponseBody
	public String doSelect(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,Notice no,HttpServletResponse res) throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("nrange", StringUtil.formatLike(no.getNrange()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Notice> noList=noticeService.queryNotice(map);
        Long total=noticeService.queryCount(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(noList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(res, result);
        return null;
    }
}
