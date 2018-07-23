package com.tsms.entity;

public class Taxpayer {

	private int id;
	private String payerCode;
	private String payerName;
	private String bizAddress;
	private int taxOrganId;
	private int industryId;
	private String bizScope;
	private String invoiceType;
	private String legalPerson;
	private String legalIdCard;
	private String legalMobile;
	private String legalIdCardImageURL;
	private String finaceName;
	private String finaceIdCard;
	private String finaceMobile;
	private String finaceIdCardImageURL;
	private String texerName;
	private String texerIdCard;
	private String texerMobile;
	private String texerIdCardImageURL;
	private String bizAddressPhone;
	private String recordDate;
	private String userId;
	private String removeState;
	public Taxpayer() {
		// TODO Auto-generated constructor stub
	}
	
	public Taxpayer(int id, String payerName, String bizAddress, int taxOrganId, int industryId, String bizScope,
			String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard,
			String bizAddressPhone) {
		super();
		this.id = id;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.bizAddressPhone = bizAddressPhone;
	}
	
	
	public Taxpayer(String payerCode, String payerName, String bizAddress, int taxOrganId, int industryId,
			String bizScope, String invoiceType, String legalPerson, String legalIdCard, String legalIdCardImageURL,
			String finaceName, String finaceIdCard, String finaceIdCardImageURL, String bizAddressPhone,
			String recordDate, String userId) {
		super();
		this.payerCode = payerCode;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.legalIdCardImageURL = legalIdCardImageURL;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.finaceIdCardImageURL = finaceIdCardImageURL;
		this.bizAddressPhone = bizAddressPhone;
		this.recordDate = recordDate;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getBizAddress() {
		return bizAddress;
	}
	public void setBizAddress(String bizAddress) {
		this.bizAddress = bizAddress;
	}
	public int getTaxOrganId() {
		return taxOrganId;
	}
	public void setTaxOrganId(int taxOrganId) {
		this.taxOrganId = taxOrganId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getBizScope() {
		return bizScope;
	}
	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLegalIdCard() {
		return legalIdCard;
	}
	public void setLegalIdCard(String legalIdCard) {
		this.legalIdCard = legalIdCard;
	}
	public String getLegalMobile() {
		return legalMobile;
	}
	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}
	public String getLegalIdCardImageURL() {
		return legalIdCardImageURL;
	}
	public void setLegalIdCardImageURL(String legalIdCardImageURL) {
		this.legalIdCardImageURL = legalIdCardImageURL;
	}
	public String getFinaceName() {
		return finaceName;
	}
	public void setFinaceName(String finaceName) {
		this.finaceName = finaceName;
	}
	public String getFinaceIdCard() {
		return finaceIdCard;
	}
	public void setFinaceIdCard(String finaceIdCard) {
		this.finaceIdCard = finaceIdCard;
	}
	public String getFinaceMobile() {
		return finaceMobile;
	}
	public void setFinaceMobile(String finaceMobile) {
		this.finaceMobile = finaceMobile;
	}
	public String getFinaceIdCardImageURL() {
		return finaceIdCardImageURL;
	}
	public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
		this.finaceIdCardImageURL = finaceIdCardImageURL;
	}
	public String getTexerName() {
		return texerName;
	}
	public void setTexerName(String texerName) {
		this.texerName = texerName;
	}
	public String getTexerIdCard() {
		return texerIdCard;
	}
	public void setTexerIdCard(String texerIdCard) {
		this.texerIdCard = texerIdCard;
	}
	public String getTexerMobile() {
		return texerMobile;
	}
	public void setTexerMobile(String texerMobile) {
		this.texerMobile = texerMobile;
	}
	public String getTexerIdCardImageURL() {
		return texerIdCardImageURL;
	}
	public void setTexerIdCardImageURL(String texerIdCardImageURL) {
		this.texerIdCardImageURL = texerIdCardImageURL;
	}
	public String getBizAddressPhone() {
		return bizAddressPhone;
	}
	public void setBizAddressPhone(String bizAddressPhone) {
		this.bizAddressPhone = bizAddressPhone;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRemoveState() {
		return removeState;
	}
	public void setRemoveState(String removeState) {
		this.removeState = removeState;
	}
	
	
}
