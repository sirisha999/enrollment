package com.app.enrollment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer trainingId;
	private Integer courseId;
	private String batchName;

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date startDate;
	  
	 // @DateTimeFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date endDate;
	 
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	  public Date getStartDate() { return startDate; } public void
	  setStartDate(Date startDate) { this.startDate = startDate; } public Date
	  getEndDate() { return endDate; } public void setEndDate(Date endDate) {
	  this.endDate = endDate; }
	 
	
}
