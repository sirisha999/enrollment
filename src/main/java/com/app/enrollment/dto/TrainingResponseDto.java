package com.app.enrollment.dto;

import java.util.List;

public class TrainingResponseDto {

	private List<TrainingDto> trainingDto;
	 
	 private String responseMessage;
	 
	 private Integer responseCode;

	public List<TrainingDto> getTrainingDto() {
		return trainingDto;
	}

	public void setTrainingDto(List<TrainingDto> trainingDto) {
		this.trainingDto = trainingDto;
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
