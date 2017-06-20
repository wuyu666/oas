package com.chinasofti.oas.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * lixianfeng
 * @author Administrator
 *
 */
public class Notice {
//	公告id
	private Integer nid;
//	公告范围
	private String nrange;
//	公告主题
	private String ntheme;
//	公告内容
	private String ncontent;
//	创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date ntime;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNrange() {
		return nrange;
	}
	public void setNrange(String nrange) {
		this.nrange = nrange;
	}
	public String getNtheme() {
		return ntheme;
	}
	public void setNtheme(String ntheme) {
		this.ntheme = ntheme;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", nrange=" + nrange + ", ntheme=" + ntheme + ", ncontent=" + ncontent
				+ ", ntime=" + ntime + "]";
	}
	
}
