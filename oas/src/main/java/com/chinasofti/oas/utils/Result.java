package com.chinasofti.oas.utils;

public class Result {
	private int status;
	private String tip;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", tip=" + tip + "]";
	}
	
}
