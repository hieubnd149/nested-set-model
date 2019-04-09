package com.bndhieu.sample.nsm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bndhieu.sample.nsm.model.Employee;
import com.bndhieu.sample.nsm.model.domain.EmployeeDomain;
import com.bndhieu.sample.nsm.repository.EmployeeRepository;

/**
 * @author hieubui
 * @date Dec 1, 2018
 *
 */
@Service
public class EmployeeTreeService {

//	@Autowired
//	private EntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addEmployee(EmployeeDomain employeeDomain, EmployeeDomain employeeRelationDomain) {
		Optional<Employee> eOptional = employeeRepository.findById(employeeDomain.getEmployeeId());
		Optional<Employee> eROptional = employeeRepository.findById(employeeRelationDomain.getEmployeeId());
		
		if (eOptional.isPresent() && eROptional.isPresent()) {
//			Employee employee = eOptional.get();
//			Employee employeeRelation = eROptional.get();
//			
//			
		}
	}
	
}
