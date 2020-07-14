package com.app.enrollment.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.enrollment.model.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer>{

	public List<Enrollment> findByTrainingId(Integer id);
}
