package com.spring.marcom174.model;

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
@Table(name="M_EMPLOYEE")
public class EmployeeModel {
	
	private Integer id;
	private String idEmployee, employeeName;
	
	//join table company
	private Integer idCompany;
	private CompanyModel companyModel;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_EMPLOYEE")
	@TableGenerator(name="M_EMPLOYEE", table="M_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="M_EMPLOYEE_ID",
						valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="NAMA")
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name="ID_EMPLOYEE")
	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Column(name="ID_COMPANY")
	public Integer getIdCompany() {
		return idCompany;
	}

	
	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}
	@ManyToOne
	@JoinColumn(name="ID_COMPANY", nullable=true, updatable=false, insertable=false)
	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}
	
}
