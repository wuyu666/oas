package com.chinasofti.oas.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
/**
 * 返回json数据
 * @author Administrator
 *
 */
public class ResponseUtil {
	public static void write(HttpServletResponse response,Object object)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(object);
        out.flush();
        out.close();
    }
}
