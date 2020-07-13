package com.app.enrollment.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingReqDto {
	private Integer courseId;
	private String batchName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat
	private Date startDate;
	@JsonFormat
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
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
}
