package com.rajan.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.employee.model.Employee;
import com.rajan.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	@PostMapping("/employee/add")
	public ResponseEntity<Object> postEmployee(@RequestBody Employee employee)
	{
		repo.save(employee);
		return new ResponseEntity(employee,HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> putEmployee(@PathVariable("id") int id, @RequestBody Employee employee)
	{
		try
		{
			Employee emp = repo.findById(id).get();
		
			emp.setExperience(employee.getExperience());
			repo.save(emp);
			return new ResponseEntity(emp, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity("No Employee found with give Id", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employee/{department}")
	public ResponseEntity<Object> getEmployee(@PathVariable("department") String department)
	{
		try
		{
			List<Employee> employees = repo.findAllByDepartment(department);
			if(employees.size() == 0)
				return new ResponseEntity("No Employee found for Department " + department , HttpStatus.NOT_FOUND);	
			return new ResponseEntity(employees,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity("No Employee found for Department " + department , HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable("id") int id)
	{
		try
		{
			Employee emp = repo.findById(id).get();
			repo.delete(emp);
			return new ResponseEntity(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
}
