package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaxpayerDao;
import com.tsms.entity.Taxpayer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxpayerDaoImpl implements TaxpayerDao {
	
	private DBUtil db = DBUtil.getInstance();

	private List<Map<String, String>>  list;
	
	private String sql = "";
	/**
	 * 分页查询纳税人信息表
	 */
	@Override
	public List<Map<String, String>> getListTaxPayer(String payerCode,String payerName,int pageNo,int pageSize) {
		if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id where p.payerCode=? and p.payerName=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerCode,payerName,(pageNo-1)*pageSize,pageSize);
		}else if(StringUtil.isNotBlank(payerName)){
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id where p.payerName=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerName,(pageNo-1)*pageSize,pageSize);
		}else if(StringUtil.isNotBlank(payerCode)){
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id where p.payerCode=? and p.removeState=0 limit ?,?";
			list = db.query(sql,payerCode,(pageNo-1)*pageSize,pageSize);
		}else{
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id where p.removeState=0 limit ?,?";
			list = db.query(sql,(pageNo-1)*pageSize,pageSize);
			
		}
		
		return list;
	}

	/**
	 * 查询信息表总条数
	 */
	@Override
	public int getCount(String payerCode,String payerName) {
		if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			sql = "select count(*) cou from tb_tax_payer  where payerCode=? and payerName=? and removeState=0 ";
			list = db.query(sql,payerCode,payerName);
		}else if(StringUtil.isNotBlank(payerCode)){
			sql = "select count(*) cou from tb_tax_payer  where payerCode=? and removeState=0 ";
			list = db.query(sql,payerCode);
		}else if(StringUtil.isNotBlank(payerName)){
			sql = "select count(*) cou from tb_tax_payer  where payerName=? and removeState=0 ";
			list = db.query(sql,payerName);
		}else{
			list = db.query("select count(*) cou from tb_tax_payer where removeState=0");
		}
		return Integer.parseInt(list.get(0).get("cou"));
	}

	/**
	 * 根据id查询信息
	 */
	@Override
	public List<Map<String, String>> getTaxPayerInfoById(int id) {
		list = db.query("select *,ta.taxerName tN from tb_tax_payer p join tb_tax_organ o join tb_user u join tb_taxer ta join tb_industry i on p.taxOrganId=o.id and p.userId=u.taxerId and u.taxerId = ta.id and p.industryId=i.id where  p.id=?  and p.removeState=0 ", id);
		return list;
	}

	/**
	 * 根据id删除信息
	 */
	@Override
	public boolean deleteTaxPayerById(int id) {
		sql = "update tb_tax_payer set removeState = 1 where id=?";
		Object [] params = {id};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 根据id查找需要修改的信息
	 */
	@Override
	public Map<String, String> updateTaxPayerById(int id) {
		sql = "select *,ta.taxerName tN from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer ta join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and u.taxerId=ta.id where p.id=?";
		Map<String, String> result = db.queryOneRow(sql, id);
		return result;
	}

	/**
	 * 修改信息
	 */
	@Override
	public boolean updateTaxPayerInfo(Taxpayer tp) {
		sql = "update tb_tax_payer set payerName=?,bizAddress=?,bizAddressPhone=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=? where id=?";
		Object [] params = {tp.getPayerName(),tp.getBizAddress(),tp.getBizAddressPhone(),tp.getTaxOrganId(),tp.getIndustryId(),tp.getBizScope(),tp.getInvoiceType(),tp.getLegalPerson(),tp.getLegalIdCard(),tp.getFinaceName(),tp.getFinaceIdCard(),tp.getId()};
		boolean b = db.update(sql, params);
		return b;
	}

	
	/**
	 * 添加
	 */
	@Override
	public boolean addTaxPayer(Taxpayer tp) {
		sql = "insert into tb_tax_payer (payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,legalIdCardImageURL,finaceName,finaceIdCard,finaceIdCardImageURL,userId,recordDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object [] params = {tp.getPayerCode(),tp.getPayerName(),tp.getBizAddress(),tp.getBizAddressPhone(),tp.getTaxOrganId(),tp.getIndustryId(),tp.getBizScope(),tp.getInvoiceType(),tp.getLegalPerson(),tp.getLegalIdCard(),tp.getLegalIdCardImageURL(),tp.getFinaceName(),tp.getFinaceIdCard(),tp.getFinaceIdCardImageURL(),tp.getUserId(),tp.getRecordDate()};
		boolean b = db.update(sql, params);
		return b;
	}

	
}
