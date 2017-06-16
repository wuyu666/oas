package com.chinasofti.oas.bean;

import java.util.Date;

public class Personal {
    private int uid;
    private String uname;
    private String usex;
    private int uage;
    private String utel;
    private double usalary;//薪水
    private String uadress;
    private String uemail;
    private Date uhiredate;//入职时间
    private Date uzzsj;//转正时间
    private String umarry;
    private String upotourl;//照片
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public double getUsalary() {
		return usalary;
	}
	public void setUsalary(double usalary) {
		this.usalary = usalary;
	}
	public String getUadress() {
		return uadress;
	}
	public void setUadress(String uadress) {
		this.uadress = uadress;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	public Date getUhiredate() {
		return uhiredate;
	}
	public void setUhiredate(Date uhiredate) {
		this.uhiredate = uhiredate;
	}
	public Date getUzzsj() {
		return uzzsj;
	}
	public void setUzzsj(Date uzzsj) {
		this.uzzsj = uzzsj;
	}
	public String getUmarry() {
		return umarry;
	}
	public void setUmarry(String umarry) {
		this.umarry = umarry;
	}
	public String getUpotourl() {
		return upotourl;
	}
	public void setUpotourl(String upotourl) {
		this.upotourl = upotourl;
	}
	@Override
	public String toString() {
		return "Personal [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", uage=" + uage + ", utel=" + utel
				+ ", usalary=" + usalary + ", uadress=" + uadress + ", uemail=" + uemail + ", uhiredate=" + uhiredate
				+ ", uzzsj=" + uzzsj + ", umarry=" + umarry + ", upotourl=" + upotourl + "]";
	}
    
}
