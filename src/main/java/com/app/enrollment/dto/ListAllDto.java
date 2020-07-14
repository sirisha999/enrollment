package com.app.enrollment.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ListAllDto {
	private Integer trainingId;
	private Integer courseId;
	private String batchName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	private  List<Integer> empIds;
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
	public List<Integer> getEmployeeId() {
		return empIds;
	}
	public void setEmployeeId(List<Integer> empIds) {
		this.empIds = empIds;
	}
}
