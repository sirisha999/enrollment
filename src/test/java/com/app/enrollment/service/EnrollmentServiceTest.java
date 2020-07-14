package com.app.enrollment.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.enrollment.dto.EnrollmentReqDto;
import com.app.enrollment.dto.TrainingReqDto;
import com.app.enrollment.model.Enrollment;
import com.app.enrollment.model.Training;
import com.app.enrollment.repository.EnrollmentRepository;
import com.app.enrollment.repository.TrainingRepository;
import com.app.enrollment.service.impl.EnrollmentServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {
@InjectMocks
EnrollmentServiceImpl enrollmentService;

@Mock
private EnrollmentRepository enrollmentRepository;
@Mock
private TrainingRepository trainingRepository;

private List<Training>trainings=new ArrayList<>();

Training trainingOne=new Training();

Training trainingTwo=new Training();

@Before
public void setup() {
	
	
	trainingOne.setTrainingId(1);
	
	trainingTwo.setTrainingId(2);
	trainings.add(trainingOne);
	trainings.add(trainingTwo);
}
	@Test
	public void testAddTraining() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=null;
		Date endDate =null;
		try {
			 startDate =format.parse("2020-08-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		try {
			endDate=format.parse("2020-09-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		TrainingReqDto trainingReqDto=new TrainingReqDto();
		trainingReqDto.setCourseName("java");
		trainingReqDto.setStartDate(startDate);
		trainingReqDto.setEndDate(endDate);
		Training training=new Training();
		training.setTrainingId(1);
		when(trainingRepository.save(Mockito.any(Training.class))).thenReturn(training);
		assertTrue(enrollmentService.addTraining(1,trainingReqDto).contains("1"));
		
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
	
	@Test
	public void testSearchTraining() {
		EnrollmentReqDto enrollmentReqDto =new EnrollmentReqDto();
		Enrollment enrollment=new Enrollment();
		enrollment.setTrainingId(2);
		enrollmentReqDto.setTrainingId(2);
		enrollment.setEnrollmentId(3);
		
		when(trainingRepository.findByCourseIdOrderByBatchName(2)).thenReturn(trainings);
		assertEquals(2,enrollmentService.searchTrainings("java",2).size());
		
	}
	
	@Test
	public void testFindAll() {
		EnrollmentReqDto enrollmentReqDto =new EnrollmentReqDto();
		List<Enrollment> enrollments=new ArrayList<>();
		Enrollment enrollment=new Enrollment();
		enrollment.setTrainingId(2);
		enrollmentReqDto.setTrainingId(2);
		enrollment.setEnrollmentId(3);
		enrollments.add(enrollment);
		when(enrollmentRepository.findByTrainingId(Mockito.anyInt())).thenReturn(enrollments);
		when(trainingRepository.findByCourseIdOrderByBatchName(2)).thenReturn(trainings);
		assertEquals(2,enrollmentService.findAll(2).size());
		
	}
}
