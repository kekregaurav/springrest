package com.spring.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
@Entity
public class Person {
    @Id
	private long pid;
	private String fname;
	private String lname;
	private String sexcd;
	private Date brthdt;
	private String phnm;
	private String emailid;
	
	public Person(){
		pid=0L;
		fname="";
		lname="";
		sexcd="Male";
		brthdt=Calendar.getInstance().getTime();
		phnm="";
		emailid="";
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSexcd() {
		return sexcd;
	}

	public void setSexcd(String sexcd) {
		this.sexcd = sexcd;
	}

	public Date getBrthdt() {
		return brthdt;
	}

	public void setBrthdt(Date brthdt) {
		this.brthdt = brthdt;
	}

	public String getPhnm() {
		return phnm;
	}

	public void setPhnm(String prmcntnum) {
		this.phnm = prmcntnum;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void getClone(Person pPrsn) {
		
		this.brthdt = pPrsn.getBrthdt();
		this.emailid = pPrsn.getEmailid();
		this.fname = pPrsn.getFname();
		this.lname = pPrsn.getLname();
		this.phnm = pPrsn.getPhnm();
		this.sexcd = pPrsn.getSexcd();
	}

}
