package com.spring.marcom174.model;

import java.util.Date;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="M_USER")
public class UserModel {
	
	private Integer id;
	private String username;
	private String password;
	
	//-----------trail--------
	private Integer isDelete;
	private String createdBy;

	private Date createdDate;
	private String updatedBy;

	private Date updatedDate;
	//---------trail-----
		
	
	//join table role
	private Integer idRole;
	private RoleModel roleModel;
	
	//join table employee
	private Integer idEmployee;
	private EmployeeModel employeeModel;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_USER")
	@TableGenerator(name="M_USER", table="M_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_USER_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="ID_ROLE")
	public Integer getIdRole() {
		return idRole;
	}
	
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_ROLE", nullable=true, updatable=false, insertable=false)
	public RoleModel getRoleModel() {
		return roleModel;
	}
	
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
	@Column(name="ID_EMPLOYEE")
	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLOYEE", nullable=true, updatable=false, insertable=false)
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
	
	@Column(name="IS_DELETE",nullable=false)
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
