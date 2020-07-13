package com.app.enrollment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="http://EMPLOYEE-SERVICE/employeeService/employee")
public interface EmployeeClient {
	@GetMapping("/getCourse/{id}")
	public CourseResponseDto getCourse(@PathVariable Integer id);
	
	@GetMapping("/getCourseByName/{courseName}")
	public CourseResponseDto getCourseByName(@PathVariable String courseName);
	
	@GetMapping("/getEmployee/{id}")
	public EmployeeResponseDto getEmployee(@PathVariable Integer id);
}
