package com.rajan.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.rajan.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findBydepartment(String department);

	List<Employee> findAllByDepartment(String department);

}
