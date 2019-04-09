package com.bndhieu.sample.nsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bndhieu.sample.nsm.model.domain.EmployeeDomain;
import com.bndhieu.sample.nsm.service.DataInitializationService;
import com.bndhieu.sample.nsm.service.EmployeeTreeService;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
@RestController
@RequestMapping("/tree")
public class EmployeeTreeController {

	@Autowired
	private DataInitializationService initDataService;

	@Autowired
	private EmployeeTreeService employeeTreeService;
	
	@PostMapping
	public String addEmployee(@RequestParam("employee") EmployeeDomain employee,
			@RequestParam("relation") EmployeeDomain relation) {
		
		employeeTreeService.addEmployee(employee, relation);
		
		return "";
	}

	@PostMapping("/generate")
	public String generateSampleTree() {
		initDataService.generateData();
		return "";
	}

	@GetMapping("/generate")
	public String printSampleTree() {
		return "";
	}
	
}
