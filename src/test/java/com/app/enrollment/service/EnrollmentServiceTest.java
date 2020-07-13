package com.app.enrollment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.enrollment.dto.EnrollmentReqDto;
import com.app.enrollment.dto.TrainingReqDto;
import com.app.enrollment.model.Enrollment;
import com.app.enrollment.model.Training;
import com.app.enrollment.repository.EnrollmentRepository;
import com.app.enrollment.repository.TrainingRepository;
import com.app.enrollment.service.impl.EnrollmentServiceImpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {
@InjectMocks
EnrollmentServiceImpl enrollmentService;

@Mock
EnrollmentRepository enrollmentRepository;
@Mock
TrainingRepository trainingRepository;
	@Test
	public void testAddTraining() {
		TrainingReqDto trainingReqDto=new TrainingReqDto();
		trainingReqDto.setCourseId(1);
		Training training=new Training();
		training.setTrainingId(1);
		when(trainingRepository.save(Mockito.any(Training.class))).thenReturn(training);
		assertTrue(enrollmentService.addTraining(trainingReqDto).contains("1"));
		
	}
	
	@Test
	public void testEnrollTraining() {
		EnrollmentReqDto enrollmentReqDto =new EnrollmentReqDto();
		Enrollment enrollment=new Enrollment();
		enrollment.setTrainingId(2);
		enrollmentReqDto.setTrainingId(2);
		enrollment.setEnrollmentId(3);
		when(enrollmentRepository.save(Mockito.any(Enrollment.class))).thenReturn(enrollment);
		assertTrue(enrollmentService.enrollTraining(enrollmentReqDto).contains("3"));
		
	}
}
