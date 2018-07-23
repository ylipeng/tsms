package com.tsms.entity;

public class Taxer {
	
	private int id;
	private String taxerCode;
	private String taxerName;
	private String mobile;
	private String address;
	private String sex;
	private String birthday;
	private String email;
	private int organId;
	private int state;
	private int mgr;
	private int admin;
	private String recordDate;
	private String recoordUserId;
	
	
	public Taxer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Taxer(String taxerCode, String taxerName, String mobile, String address, String sex, String birthday,
			String email, int organId) {
		super();
		this.taxerCode = taxerCode;
		this.taxerName = taxerName;
		this.mobile = mobile;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.organId = organId;
	}


	public Taxer(int id, String taxerCode, String taxerName, String mobile, String address, String sex,
			String birthday, String email, int organId) {
		super();
		this.id = id;
		this.taxerCode = taxerCode;
		this.taxerName = taxerName;
		this.mobile = mobile;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.organId = organId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaxerCode() {
		return taxerCode;
	}
	public void setTaxerCode(String taxerCode) {
		this.taxerCode = taxerCode;
	}
	public String getTaxerName() {
		return taxerName;
	}
	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOrganId() {
		return organId;
	}
	public void setOrganId(int organId) {
		this.organId = organId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecoordUserId() {
		return recoordUserId;
	}
	public void setRecoordUserId(String recoordUserId) {
		this.recoordUserId = recoordUserId;
	}
	
	
	

}
