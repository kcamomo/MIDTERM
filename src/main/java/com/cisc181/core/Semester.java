package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {

	private UUID SemesterID;
	private Date startDate;
	private Date endDate;


	public Semester(UUID semesterID, Date startDate, Date endDate) {
		super();
		this.SemesterID = semesterID;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public UUID getSemesterID() {
		return SemesterID;
	}


	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}