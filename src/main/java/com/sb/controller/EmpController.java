package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sb.dao.EmployeeRepo;
import com.sb.entity.Employee;

@RestController
public class EmpController {
	
	@Autowired
	private EmployeeRepo erepo;
	
	@GetMapping("/form")
	public String index() {
		return "Myfile.html";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		erepo.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("/display-all")
	public List<Employee> displayAll(){
		return erepo.findAll();
	}
	
	@GetMapping("/display/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return erepo.findById(id).get();
	}
	
	

}
