package com.app.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.enrollment.clients.CourseDto;
import com.app.enrollment.clients.CourseResponseDto;
import com.app.enrollment.clients.EmployeeClient;
import com.app.enrollment.clients.EmployeeResponseDto;
import com.app.enrollment.dto.EnrollmentReqDto;
import com.app.enrollment.dto.ListAllDto;
import com.app.enrollment.dto.TrainingDto;
import com.app.enrollment.dto.TrainingReqDto;
import com.app.enrollment.dto.TrainingResponseDto;
import com.app.enrollment.service.impl.EnrollmentServiceImpl;

@RestController
@EnableEurekaClient
@RequestMapping("/enrollment")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceImpl enrollmentService;
	
	@Autowired
	EmployeeClient employeeClient;

	@PostMapping("/addTraining")
	public ResponseEntity<String> addTraining(@RequestBody TrainingReqDto trainingReqDto){
		CourseResponseDto courseResponseDto= employeeClient.getCourse(trainingReqDto.getCourseId());
		if(courseResponseDto.getCourseDto()!=null) {
			String message=enrollmentService.addTraining(trainingReqDto);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("course not found", HttpStatus.NOT_FOUND);
			
	}
	
	@PostMapping("/enrollTraining")
	public ResponseEntity<String> enrollTraining(EnrollmentReqDto enrollmentReqDto){
		EmployeeResponseDto dto=employeeClient.getEmployee(enrollmentReqDto.getEmployeeId());
		if(dto.getEmployeeDto()!=null) {
		String message=enrollmentService.enrollTraining(enrollmentReqDto);
			return new ResponseEntity<>(message, HttpStatus.CREATED);}
		else
			return new ResponseEntity<>("employee not found to enroll", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/search/{courseName}")
	public TrainingResponseDto searchTrainings(@PathVariable String courseName){
		TrainingResponseDto dto=new TrainingResponseDto();
		CourseResponseDto courseDto=employeeClient.getCourseByName(courseName);
		List<TrainingDto> dtos=enrollmentService.searchTrainings(courseDto.getCourseDto().getCourseName(),courseDto.getCourseDto().getCourseId());
		dto.setTrainingDto(dtos);
		dto.setResponseCode(200);
		dto.setResponseMessage("search success");
		return dto;
	}
	
	@GetMapping("/listAll/{courseName}")
	public List<ListAllDto> listAll(@PathVariable String courseName){
	//	TrainingResponseDto dto=new TrainingResponseDto();
		CourseResponseDto courseDto=employeeClient.getCourseByName(courseName);
			return enrollmentService.findAll(courseDto.getCourseDto().getCourseId());
	}
	
	
}
