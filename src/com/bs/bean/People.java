package com.bs.bean;

public class People implements java.io.Serializable
{
	private int pid;
	private String pname;
	private String prealname;
	private String pxuehao;
	private String password;
	private String phone;
	private String pduanhao;
	private String psex;
	private String paddress;
	private String pxueyuan;
	private String psecurity;
	private String pjianjie;
	private int pself;
	
	public People(){
	}
	public People(int pid,String pname,String prealname,String pxuehao,String password,String phone,
			String pduanhao,String psex,String paddress,String pxueyuan,String psecurity,String pjianjie,int pself){
		this.pid=pid;
		this.pname=pname;
		this.prealname=prealname;
		this.pxuehao=pxuehao;
		this.password=password;
		this.phone=phone;
		this.pduanhao=pduanhao;
		this.psex=psex;
		this.paddress=paddress;
		this.pxueyuan=pxueyuan;
		this.psecurity=psecurity;
		this.pjianjie=pjianjie;
		this.pself=pself;	
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	
	public String getPrealname() {
		return prealname;
	}
	public void setPrealname(String prealname) {
		this.prealname = prealname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPxuehao() {
		return pxuehao;
	}
	public void setPxuehao(String pxuehao) {
		this.pxuehao = pxuehao;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPduanhao() {
		return pduanhao;
	}
	public void setPduanhao(String pduanhao) {
		this.pduanhao = pduanhao;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getPxueyuan() {
		return pxueyuan;
	}
	public void setPxueyuan(String pxueyuan) {
		this.pxueyuan = pxueyuan;
	}
	public String getPsecurity() {
		return psecurity;
	}
	public void setPsecurity(String psecurity) {
		this.psecurity = psecurity;
	}
	public String getPjianjie() {
		return pjianjie;
	}
	public void setPjianjie(String pjianjie) {
		this.pjianjie = pjianjie;
	}
	public int getPself() {
		return pself;
	}
	public void setPself(int pself) {
		this.pself = pself;
	}
	
	
}
