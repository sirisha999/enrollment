package com.app.enrollment.clients;

public class CourseResponseDto {

	private CourseDto courseDto;
	 
	 private String responseMessage;
	 
	 private Integer responseCode;

	public CourseDto getCourseDto() {
		return courseDto;
	}

	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
}
