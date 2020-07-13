package com.app.enrollment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enrollmentId;
	private Integer trainingId;
	private Integer employeeId;
	public Integer getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
