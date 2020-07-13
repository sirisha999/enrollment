package com.app.enrollment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.enrollment.model.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer>{

	public Enrollment findByTrainingId(Integer id);
}
