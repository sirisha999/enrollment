package com.app.enrollment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.enrollment.dto.EnrollmentReqDto;
import com.app.enrollment.dto.ListAllDto;
import com.app.enrollment.dto.TrainingReqDto;
import com.app.enrollment.dto.TrainingDto;
import com.app.enrollment.model.Enrollment;
import com.app.enrollment.model.Training;
import com.app.enrollment.repository.EnrollmentRepository;
import com.app.enrollment.repository.TrainingRepository;
import com.app.enrollment.service.EnrollmentService;
@Service
public class EnrollmentServiceImpl implements EnrollmentService{
	
	Logger logger=LoggerFactory.getLogger(EnrollmentServiceImpl.class);
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	TrainingRepository trainingRepository;
	public String addTraining(TrainingReqDto trainingReqDto) {
		Training training=new Training();
			BeanUtils.copyProperties(trainingReqDto,training );
		 training=trainingRepository.save(training);
		 logger.info("new training successfully added");
		return "new training successfully added with id:"+training.getTrainingId();
	}
	
	public String enrollTraining(EnrollmentReqDto enrollmentReqDto) {
		Enrollment enrollment=new Enrollment();
			BeanUtils.copyProperties(enrollmentReqDto, enrollment);
		enrollment=enrollmentRepository.save(enrollment);
		return "employee  successfully enrolled with id:"+enrollment.getEnrollmentId();
		
	}
	
	public List<TrainingDto> searchTrainings (String courseName,Integer courseId) {
		List<Training> training=trainingRepository.findByCourseId(courseId);
		List<TrainingDto> trainingDtos=training.stream().map(a->EnrollmentServiceImpl.getTrainingDtoFromEntity(courseName,a))
		.collect(Collectors.toList());
		return trainingDtos;
		
	}
	
	public List<ListAllDto> findAll(Integer courseId) {
		logger.info("course id is"+courseId);
		List<Training> trainings=trainingRepository.findByCourseId(courseId);
		List<ListAllDto> dt=new ArrayList<>();
		List<ListAllDto> toBeRemoved=new ArrayList<>();
		for (Training training: trainings) {
			dt.add(getfindAllDtoFromEntity(training));
		
		}
		for(ListAllDto d :dt) {
			logger.info("training id is"+d.getTrainingId());
		Enrollment e=enrollmentRepository.findByTrainingId(d.getTrainingId());
		if(e!=null)
		d.setEmployeeId(e.getEmployeeId());
		else
			toBeRemoved.add(d);
		}
		dt.removeAll(toBeRemoved);
		return dt;
		
	}
	private static TrainingDto getTrainingDtoFromEntity(String courseName,Training userOrder) {
		TrainingDto userOrderDto = new TrainingDto();
			BeanUtils.copyProperties(userOrder, userOrderDto);
		userOrderDto.setCourseName(courseName);
		return userOrderDto;
	}
	
	private static ListAllDto getfindAllDtoFromEntity(Training userOrder) {
		ListAllDto findAllDto=new ListAllDto();
			BeanUtils.copyProperties(userOrder, findAllDto);
		return findAllDto;
	}

}
