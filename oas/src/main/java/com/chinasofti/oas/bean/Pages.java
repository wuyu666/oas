package com.chinasofti.oas.bean;

import java.util.List;

public class Pages<T> {
	private T query;
	private Integer pageSize=10;
	private Integer curPage=1;
	private Integer start;
	
	private int total;
	private List<T> rows;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public int getStart() {
		start=(curPage-1)*pageSize;
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public T getQuery() {
		return query;
	}

	public void setQuery(T query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "Pages [query=" + query + ", pageSize=" + pageSize + ", curPage=" + curPage + ", start=" + start
				+ ", total=" + total + ", rows=" + rows + "]";
	}
	
}
