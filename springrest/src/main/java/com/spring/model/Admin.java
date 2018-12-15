package com.spring.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="admin")
public class Admin extends Person {

	private char acssLvl;
	private String desigCd;
	private boolean acssBlckd;

	public char getAcssLvl() {
		return acssLvl;
	}

	public void setAcssLvl(char acssLvl) {
		this.acssLvl = acssLvl;
	}

	public String getDesigCd() {
		return desigCd;
	}

	public void setDesigCd(String desigCd) {
		this.desigCd = desigCd;
	}

	public boolean isAcssBlckd() {
		return acssBlckd;
	}

	public void setAcssBlckd(boolean acssBlckd) {
		this.acssBlckd = acssBlckd;
	}

}
