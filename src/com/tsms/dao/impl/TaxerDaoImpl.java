package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaxerDao;
import com.tsms.entity.Taxer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxerDaoImpl implements TaxerDao {
	
	private DBUtil db = DBUtil.getInstance();

	private List<Map<String, String>>  list;
	
	private Map<String, String> result;
	
	private String sql = "";

	/**
	 * 分页展示所有信息
	 */
	@Override
	public List<Map<String, String>> getListTaxer(String taxerName,int pageNo,int pageSize) {
		if(StringUtil.isNotBlank(taxerName)){
			sql = "select * from tb_taxer where state=0 and recordName=? limit ?,?";
			list = db.query(sql,taxerName,(pageNo-1)*pageSize,pageSize);
		}else{
			sql = "select * from tb_taxer where state=0  limit ?,?";
			list = db.query(sql,(pageNo-1)*pageSize,pageSize);
		}
		return list;
	}

	
	/**
	 * 获取信息数量
	 * @return
	 */
	@Override
	public int getTaxerCount(String taxerName) {
		if(StringUtil.isNotBlank(taxerName)){
			sql = "select count(*) cou from tb_taxer where state=0 and recordName=?";
			list = db.query(sql,taxerName);
		}else{
			sql = "select count(*) cou from tb_taxer where state=0 ";
			list = db.query(sql);
		}
		return Integer.parseInt(list.get(0).get("cou"));
	}


	/**
	 * 根据id获取详情
	 */
	@Override
	public Map<String, String> getTaxerInfoById(int id) {
		sql = "select * from tb_taxer ta join tb_tax_organ o on ta.organId=o.id where ta.id=?";
		result = db.queryOneRow(sql, id);
		return result;
	}


	/**
	 * 根据id删除信息
	 */
	@Override
	public boolean deleteTaxer(int id) {
		sql = "update tb_taxer set state=1 where id=?";
		Object [] params = {id};
		boolean b = db.update(sql, params);
		return b;
	}


	/**
	 * 修改
	 */
	@Override
	public boolean updateTaxer(Taxer ta) {
		sql = "update tb_taxer set taxerCode=?,taxerName=?,mobile=?,address=?,sex=?,birthday=?,email=?,organId=? where id=?";
		Object [] params = {ta.getTaxerCode(),ta.getTaxerName(),ta.getMobile(),ta.getAddress(),ta.getSex(),ta.getBirthday(),ta.getEmail(),ta.getOrganId(),ta.getId()};
		boolean b = db.update(sql, params);
		return b;
	}


	/**
	 * 添加
	 */
	@Override
	public boolean addTaxer(Taxer ta) {
		sql = "insert into tb_taxer (taxerCode,taxerName,mobile,address,sex,birthday,email,organId) values (?,?,?,?,?,?,?,?)";
		Object [] params = {ta.getTaxerCode(),ta.getTaxerName(),ta.getMobile(),ta.getAddress(),ta.getSex(),ta.getBirthday(),ta.getEmail(),ta.getOrganId()};
		boolean b = db.update(sql, params);
		return b;
	}

}
