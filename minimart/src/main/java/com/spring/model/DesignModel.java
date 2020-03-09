package com.spring.marcom174.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="T_DESIGN")
public class DesignModel {
	
	private Integer id;
	private String code;
	
	private Integer tEventId;
	private EventModel EventModel;
	
	private String titleHeader;
	
	private Integer requestBy;
	private UserModel requestByUser;
	
	private Date requestdate;
	
	private Integer approvedBy;
	private Date approvedDate;
	private UserModel approvedByUser;
	
	private Integer assignTo;
	private UserModel assignToUser;
	
	private Date closedDate;
	private String note;
	private Integer status;
	private String rejectReason;
	
	private Integer isDelete;
	private Integer createdBy;
	private UserModel createdByUser;
	private Date createdDate;
	private Integer updateBy;
	private UserModel updatedByUser;
	private Date updatedDate;
	
	private List<DesignDetailModel> designDetailModelList;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_DESIGN")
	@TableGenerator(name="T_DESIGN", table="M_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="T_DESIGN_ID",
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
	@Column(name="ID_EVENT")
	public Integer gettEventId() {
		return tEventId;
	}
	public void settEventId(Integer tEventId) {
		this.tEventId = tEventId;
	}
	@ManyToOne
	@JoinColumn(name="ID_EVENT", nullable=true, updatable=false, insertable=false)
	public EventModel getEventModel() {
		return EventModel;
	}
	public void setEventModel(EventModel eventModel) {
		EventModel = eventModel;
	}
	@Column(name="TITLE")
	public String getTitleHeader() {
		return titleHeader;
	}
	public void setTitleHeader(String titleHeader) {
		this.titleHeader = titleHeader;
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
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	@Column(name="APPROVED_BY")
	public Integer getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}
	@Column(name="APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	@ManyToOne
	@JoinColumn(name="APPROVED_BY", nullable=true, updatable=false, insertable=false)
	public UserModel getApprovedByUser() {
		return approvedByUser;
	}
	public void setApprovedByUser(UserModel approvedByUser) {
		this.approvedByUser = approvedByUser;
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
	@Column(name="CLOSED_DATE")
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
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
	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
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
	@OneToMany(fetch=FetchType.EAGER, mappedBy="designModel")
	public List<DesignDetailModel> getDesignDetailModelList() {
		return designDetailModelList;
	}
	public void setDesignDetailModelList(List<DesignDetailModel> designDetailModelList) {
		this.designDetailModelList = designDetailModelList;
	}

}
