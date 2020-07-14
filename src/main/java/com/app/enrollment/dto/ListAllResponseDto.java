package com.app.enrollment.dto;

import java.util.List;

public class ListAllResponseDto {
	private List<ListAllDto> listAllDtos;
	
	private String responseMessage;
	 
	 private Integer responseCode;

	public List<ListAllDto> getListAllDtos() {
		return listAllDtos;
	}

	public void setListAllDtos(List<ListAllDto> listAllDtos) {
		this.listAllDtos = listAllDtos;
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
