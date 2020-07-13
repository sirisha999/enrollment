package com.app.enrollment.service;

import java.util.List;

import com.app.enrollment.dto.EnrollmentReqDto;
import com.app.enrollment.dto.ListAllDto;
import com.app.enrollment.dto.TrainingDto;
import com.app.enrollment.dto.TrainingReqDto;

public interface EnrollmentService {
	
public String addTraining (TrainingReqDto trainingReqDto);

public String enrollTraining (EnrollmentReqDto enrollmentReqDto);

public List<TrainingDto> searchTrainings (String courseName,Integer courseId);

public List<ListAllDto> findAll(Integer courseId);
}
