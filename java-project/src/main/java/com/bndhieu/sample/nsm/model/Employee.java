package com.bndhieu.sample.nsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5272210853618592425L;
	private Integer employeeId;
	private String employeeName;
	private int level;
	
	public Employee() {
		
	}
	
	public Employee(final String employeeName, int level) {
		this.employeeName = employeeName;
		this.level = level;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "EMPLOYEE_NAME", nullable = false)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "EMPLOYEE_LEVEL", nullable = false)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
