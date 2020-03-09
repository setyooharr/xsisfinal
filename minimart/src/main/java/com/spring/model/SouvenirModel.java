package com.spring.marcom174.model;

import java.util.Date;

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
@Table(name="M_SOUVENIR")
public class SouvenirModel {
	
	private Integer id;
	private String code;
	private String name;
	private String desc;
	
	private Integer idUnit;
	private UnitModel unitModel;
	
	private Integer xIsDelete; 
	private String xCreatedBy;
	
	private Date xCreatedDate;
	
	private String xUpdatedBy;
	private Date xUpdatedDate;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_SOUVENIR")
	@TableGenerator(name="M_SOUVENIR", table="M_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="M_SOUVENIR_ID",
						valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0
					)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="NAMA")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="DESK")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(name="ID_UNIT")
	public Integer getIdUnit() {
		return idUnit;
	}
	public void setIdUnit(Integer idUnit) {
		this.idUnit = idUnit;
	}
	@ManyToOne
	@JoinColumn(name="ID_UNIT", nullable=true, updatable=false, insertable=false)
	public UnitModel getUnitModel() {
		return unitModel;
	}
	public void setUnitModel(UnitModel unitModel) {
		this.unitModel = unitModel;
	}
	@Column(name="X_IS_DELETE")
	public Integer getxIsDelete() {
		return xIsDelete;
	}
	public void setxIsDelete(Integer xIsDelete) {
		this.xIsDelete = xIsDelete;
	}
	@Column(name="X_CREATED_BY")
	public String getxCreatedBy() {
		return xCreatedBy;
	}
	public void setxCreatedBy(String xCreatedBy) {
		this.xCreatedBy = xCreatedBy;
	}
	
	@Column(name="X_CREATED_DATE")
	public Date getxCreatedDate() {
		return xCreatedDate;
	}
	public void setxCreatedDate(Date xCreatedDate) {
		this.xCreatedDate = xCreatedDate;
	}
	@Column(name="X_UPDATED_BY")
	public String getxUpdatedBy() {
		return xUpdatedBy;
	}
	public void setxUpdatedBy(String xUpdatedBy) {
		this.xUpdatedBy = xUpdatedBy;
	}
	
	@Column(name="X_UPDATE_DATE")
	public Date getxUpdatedDate() {
		return xUpdatedDate;
	}
	public void setxUpdatedDate(Date xUpdatedDate) {
		this.xUpdatedDate = xUpdatedDate;
	}	
} 
