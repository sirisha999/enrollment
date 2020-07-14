package com.app.enrollment.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.enrollment.clients.CourseDto;
import com.app.enrollment.clients.CourseResponseDto;
import com.app.enrollment.clients.EmployeeClient;
import com.app.enrollment.dto.ListAllDto;
import com.app.enrollment.dto.TrainingDto;
import com.app.enrollment.dto.TrainingReqDto;
import com.app.enrollment.dto.TrainingResponseDto;
import com.app.enrollment.model.Training;
import com.app.enrollment.service.impl.EnrollmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentControllerTest {
	
	@InjectMocks
	EnrollmentController enrollmentController;
	@Mock
	EnrollmentServiceImpl enrollmentService;
	
	@Mock
	EmployeeClient employeeClient;

	@Test
	public void testAddTraining() {
		
		TrainingReqDto trainingReqDto=new TrainingReqDto();
		trainingReqDto.setCourseName("java");
		Training training=new Training();
		training.setTrainingId(1);
		CourseResponseDto courseResponseDto=new CourseResponseDto();
		CourseDto courseDto=new CourseDto();
		ListAllDto listAllDto =new ListAllDto();
		listAllDto.setCourseId(1);
		ListAllDto listAllDto2 =new ListAllDto();
		listAllDto.setCourseId(1);
		listAllDto2.setCourseId(2);
		List<ListAllDto> list=new ArrayList<>();
		list.add(listAllDto);
		courseDto.setCourseId(2);
		courseResponseDto.setCourseDto(courseDto);
		when(enrollmentService.addTraining(courseResponseDto.getCourseDto().getCourseId(),trainingReqDto)).thenReturn("new training successfully added with id:1");
		when(employeeClient.getCourseByName("java")).thenReturn(courseResponseDto);
		enrollmentController.addTraining(trainingReqDto);
		assertTrue(enrollmentController.addTraining(trainingReqDto).getBody().contains("1"));
	}
	
	@Test
	public void testEnrollTraining() {
		CourseResponseDto courseResponseDto=new CourseResponseDto();
		CourseDto courseDto=new CourseDto();
		ListAllDto listAllDto =new ListAllDto();
		listAllDto.setCourseId(1);
		ListAllDto listAllDto2 =new ListAllDto();
		listAllDto.setCourseId(1);
		listAllDto2.setCourseId(2);
		List<ListAllDto> list=new ArrayList<>();
		list.add(listAllDto);
		list.add(listAllDto2);
		courseDto.setCourseId(2);
		courseResponseDto.setCourseDto(courseDto);
		when(employeeClient.getCourseByName("java")).thenReturn(courseResponseDto);
		when(enrollmentService.findAll(2)).thenReturn(list);
		assertEquals(2,enrollmentController.listAll("java").getListAllDtos().size());
		
	}
	
}


