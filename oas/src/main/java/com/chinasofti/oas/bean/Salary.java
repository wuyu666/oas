package com.chinasofti.oas.bean;

public class Salary {
private int sid;
private int svalue;
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
}
public int getSvalue() {
	return svalue;
}
public void setSvalue(int svalue) {
	this.svalue = svalue;
}
@Override
public String toString() {
	return "Salary [sid=" + sid + ", svalue=" + svalue + "]";
}

}
