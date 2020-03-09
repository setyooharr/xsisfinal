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


import com.spring.marcom174.model.EventModel;

@Entity
@Table(name="T_EVENT")
public class EventModel {
	
	private Integer id;
	private String code;
	private String eventName;
	private Date startDate;
	private Date endDate;
	private String place;
	private Integer budget;
	
	//transaction
	private Integer requestBy;
	private UserModel requestByUser;
	private Date requestDate;
	private Integer approvedBy;
	private UserModel approvedByUser;
	private Date approvedDate;
	private Integer assignTo;
	private UserModel assignToUser;
	private Date closeDate;	
	private String note;
	private Integer status;
	private String rejectReason;
	
	//audit trail
	private Integer isDelete;
	private Integer createdBy;
	private UserModel createdByUser;
	private Date createdDate;
	private Integer updatedBy;
	private UserModel updatedByUser;
	private Date updatedDate;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_EVENT")
	@TableGenerator(name="T_EVENT", table="M_SEQUENCE",
					pkColumnName="SEQUENCE_NAME", pkColumnValue="T_EVENT_ID",
					valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
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
	
	@Column(name="EVENT_NAME")
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Column(name="PLACE")
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Column(name="BUDGET")
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	
	@Column(name="REQUEST_BY")
	public Integer getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(Integer requestBy) {
		this.requestBy = requestBy;
	}
	
	@ManyToOne
	@JoinColumn(name="REQUEST_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getRequestByUser() {
		return requestByUser;
	}
	public void setRequestByUser(UserModel requestByUser) {
		this.requestByUser = requestByUser;
	}
	
	@Column(name="REQUEST_DATE")
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	@Column(name="APPROVED_BY")
	public Integer getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="APPROVED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getApprovedByUser() {
		return approvedByUser;
	}
	public void setApprovedByUser(UserModel approvedByUser) {
		this.approvedByUser = approvedByUser;
	}
	
	@Column(name="APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	@Column(name="ASSIGN_TO")
	public Integer getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(Integer assignTo) {
		this.assignTo = assignTo;
	}
	
	@ManyToOne
	@JoinColumn(name="ASSIGN_TO", nullable=true, updatable=false, insertable=false)
	public UserModel getAssignToUser() {
		return assignToUser;
	}
	public void setAssignToUser(UserModel assignToUser) {
		this.assignToUser = assignToUser;
	}
	
	@Column(name="CLOSE_DATE")
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	@Column(name="NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name="STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name="REJECT_REASON")
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
	@Column(name="IS_DELETE")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(UserModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_BY")
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="UPDATED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getUpdatedByUser() {
		return updatedByUser;
	}
	public void setUpdatedByUser(UserModel updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}