package com.spring.marcom174.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="M_UNIT")
public class UnitModel {

	private Integer id;
	private String code;
	private String nama;
	private String desc;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_UNIT")
	@TableGenerator(name="M_UNIT", table="M_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="M_UNIT_ID",
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
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	@Column(name="DESK")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
