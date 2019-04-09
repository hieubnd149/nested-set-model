package com.bndhieu.sample.nsm.repository;

import org.springframework.data.repository.CrudRepository;

import com.bndhieu.sample.nsm.model.Employee;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
