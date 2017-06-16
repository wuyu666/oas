package com.chinasofti.oas.bean;

import java.io.Serializable;

public class Page implements Serializable{
	
	
	/**
	 * 分页
	 * lixianfeng
	 */
	private static final long serialVersionUID = 1404433948121502751L;
	
	private int curPage=1;
	private int start=0;
	private int pageSize=10;
	private int count=0;
	private int total=1;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStart() {
		return (curPage-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", start=" + start + ", pageSize=" + pageSize + ", count=" + count
				+ ", total=" + total + "]";
	}
}
