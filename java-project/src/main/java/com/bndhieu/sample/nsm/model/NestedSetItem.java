package com.bndhieu.sample.nsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
@Entity()
@Table(name = "NESTED_SET_EMPLOYEE")
public class NestedSetItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3375944964383392371L;

	private int nodeId;
	private int left;
	private int right;
	private Employee employee;
	
	public NestedSetItem() {
		
	}
	
	public NestedSetItem(final Employee employee, final int left, final int right) {
		this.employee = employee;
		this.left = left;
		this.right = right;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NODE_ID", nullable = false, unique = true)
	public int getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	
	@Column(name = "LEFT_IDX", nullable = false)
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	@Column(name = "RIGHT_IDX", nullable = false)
	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
