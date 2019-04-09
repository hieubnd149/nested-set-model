package com.bndhieu.sample.nsm.model.domain;

/**
 * @author hieubui
 * @date Dec 1, 2018
 *
 */
public class EmployeeDomain {

	private Integer employeeId;
	private String employeeName;
	private Integer level;
	
	public EmployeeDomain() {
		
	}
	
	public EmployeeDomain(Integer employeeId, String employeeName, Integer level) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.level = level;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
