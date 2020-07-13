package com.app.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.enrollment.model.Training;
@Repository
public interface TrainingRepository extends JpaRepository<Training,Integer>{
public List<Training> findByCourseId(Integer id);
}
