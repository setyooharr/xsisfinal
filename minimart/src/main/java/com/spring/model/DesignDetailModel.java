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
@Table(name="M_DESIGN_DETAIL")
public class DesignDetailModel {
	
	private Integer id;
	private String titleItem;
	private String requestPic;
	private Date startDate;
	private Date endDate;
	private Date requestDueDate;
	private String note;
	
	//join table Design Model
	private Integer tDesignId;
	private DesignModel designModel;
	
	//join table Product Model
	private Integer mProductId;
	private ProductModel productModel;
	
	//-----------trail--------
	private Integer isDelete;
	private Integer createdBy;
	private UserModel createdByUser;
	private Date createdDate;
	private String updatedBy;
	private UserModel updatedByUser;
	private Date updatedDate;
	//---------trail----------
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_DESIGN_DETAIL")
	@TableGenerator(name="M_DESIGN_DETAIL", table="M_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_DESIGN_DETAIL_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="NAMA")
	public String getTitleItem() {
		return titleItem;
	}
	public void setTitleItem(String titleItem) {
		this.titleItem = titleItem;
	}
	@Column(name="REQUEST_PIC")
	public String getRequestPic() {
		return requestPic;
	}
	public void setRequestPic(String requestPic) {
		this.requestPic = requestPic;
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
	@Column(name="DUE_DATE")
	public Date getRequestDueDate() {
		return requestDueDate;
	}
	public void setRequestDueDate(Date requestDueDate) {
		this.requestDueDate = requestDueDate;
	}
	@Column(name="NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Column(name="ID_DESIGN")
	public Integer gettDesignId() {
		return tDesignId;
	}
	public void settDesignId(Integer tDesignId) {
		this.tDesignId = tDesignId;
	}
	@ManyToOne
	@JoinColumn(name="ID_DESIGN", nullable=true, updatable=false, insertable=false)
	public DesignModel getDesignModel() {
		return designModel;
	}
	public void setDesignModel(DesignModel designModel) {
		this.designModel = designModel;
	}
	@Column(name="ID_PRODUCT")
	public Integer getmProductId() {
		return mProductId;
	}
	public void setmProductId(Integer mProductId) {
		this.mProductId = mProductId;
	}
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=true, updatable=false, insertable=false)
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
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
