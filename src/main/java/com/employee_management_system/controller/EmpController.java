package com.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management_system.dto.Employee;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.repository.EmpRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmpController {
   @Autowired 
   private EmpRepository empRepository;
   
   @GetMapping
   public List<Employee>getAllEmployee(){
	   return empRepository.findAll();
   }
   
   @PostMapping
   public Employee createEmployee(@RequestBody Employee employee) {
	   return empRepository.save(employee);
   }
   
   @GetMapping("{id}")
   public ResponseEntity<Employee>getEmployeeById(@PathVariable long id){
	  Employee employee =empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id "+id));
	  return ResponseEntity.ok(employee);
   }
   
   @PutMapping
   public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
	   empRepository.save(employee);
	   return ResponseEntity.ok(employee);
   }
   
   @DeleteMapping("{id}")
   public void deleteEmployee(@PathVariable long id) {
	   empRepository.deleteById(id);
   }
   
   
}
