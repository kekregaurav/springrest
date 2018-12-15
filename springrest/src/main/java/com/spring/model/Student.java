package com.spring.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class Student extends Person {

	private int studId;
	private char swimLvl;
	private boolean ltPymtInd;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public char getSwimLvl() {
		return swimLvl;
	}

	public void setSwimLvl(char swimLvl) {
		this.swimLvl = swimLvl;
	}

	public boolean isLtPymtInd() {
		return ltPymtInd;
	}

	public void setLtPymtInd(boolean ltPymtInd) {
		this.ltPymtInd = ltPymtInd;
	}

}
