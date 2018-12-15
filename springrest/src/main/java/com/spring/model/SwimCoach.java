package com.spring.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="swimcoach")
public class SwimCoach extends Person {

	private int coachId;
	private String dlNum;
	private short exptLvl;

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getDlNum() {
		return dlNum;
	}

	public void setDlNum(String dlNum) {
		this.dlNum = dlNum;
	}

	public short getExptLvl() {
		return exptLvl;
	}

	public void setExptLvl(short exptLvl) {
		this.exptLvl = exptLvl;
	}

}
