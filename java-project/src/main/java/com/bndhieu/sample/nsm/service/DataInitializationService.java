package com.bndhieu.sample.nsm.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bndhieu.sample.nsm.model.Employee;
import com.bndhieu.sample.nsm.model.EmployeeRelation;
import com.bndhieu.sample.nsm.model.NestedSetItem;
import com.bndhieu.sample.nsm.repository.EmployeeRelationRepository;
import com.bndhieu.sample.nsm.repository.EmployeeRepository;
import com.bndhieu.sample.nsm.repository.NestedSetItemRepository;
import com.bndhieu.sample.nsm.service.tree.TreeIndexBuilder;
import com.bndhieu.sample.nsm.service.tree.TreeIndexBuilder.TreeIndex;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
@Service
public class DataInitializationService {

	private String[] employeeNames = new String[] { "JUNYOUNGJAE", "LDPHU", "BNDHIEU", "LLLTHAO", "MARTIN", "LTTHONG" };
	private int[] employeeLevels = new int[] { 1, 2, 3, 3, 2, 3 };

	private int[] employeeIds = new int[] { 1, 2, 3, 4, 5 };
	private int[] employeeRelators = new int[] { 0, 1, 1, 0, 4 };

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private NestedSetItemRepository nestedSetItemRepository;

	@Autowired
	private EmployeeRelationRepository employeeRelationRepository;

	private static final TreeIndexBuilder treeIndexBuilder = new TreeIndexBuilder();

	@Transactional
	public void generateData() {
		List<Employee> employees = createEmployees();
		buildEmployeeRelation(employees);
	}

	private List<Employee> createEmployees() {
		final int totalEmployee = employeeNames.length;
		List<Employee> employees = new ArrayList<>(totalEmployee);

		List<TreeIndex> indexes = treeIndexBuilder.build(employeeLevels);
		for (int i = 0; i < totalEmployee; ++i) {
			employees.add(createEmployee(employeeNames[i], employeeLevels[i], indexes.get(i)));
		}
		return employees;
	}

	private Employee createEmployee(String name, int level, TreeIndex treeIndex) {
		Employee employee = new Employee(name, level);

		NestedSetItem nestedModel = new NestedSetItem(employee, treeIndex.getLeft(), treeIndex.getRight());
		employeeRepository.save(employee);
		nestedSetItemRepository.save(nestedModel);

		return employee;
	}

	private void buildEmployeeRelation(List<Employee> employees) {
		Employee employee;
		Employee relation;
		EmployeeRelation employeeRelation;
		for (int i = 0; i < employeeIds.length; ++i) {
			employee = employees.get(employeeIds[i]);
			relation = employees.get(employeeRelators[i]);

			employeeRelation = new EmployeeRelation(employee, relation);
			employeeRelationRepository.save(employeeRelation);
		}
	}

}
