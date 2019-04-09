package com.bndhieu.sample.nsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author hieubui
 * @date Nov 29, 2018
 *
 */
@Entity
@Table(name = "EMPLOYEE_RELATION")
public class EmployeeRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5998654727417955064L;

	private Integer employeeId;
	
	private Employee employee;
	private Employee relativeEmployee;
	
	public EmployeeRelation() {
		
	}

	public EmployeeRelation(Employee employee, Employee relation) {
		setEmployeeId(employee.getEmployeeId());
		
		this.employee = employee;
		this.relativeEmployee = relation;
	}

	@Id
	@Column(name = "EMPLOYEE_ID")
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	@OneToOne
    @PrimaryKeyJoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@OneToOne
	@JoinColumn(name = "RELATION_ID", referencedColumnName = "EMPLOYEE_ID")
	public Employee getRelativeEmployee() {
		return relativeEmployee;
	}

	public void setRelativeEmployee(Employee above) {
		this.relativeEmployee = above;
	}
	
}
