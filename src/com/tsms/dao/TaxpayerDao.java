package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxpayer;

public interface TaxpayerDao {

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getListTaxPayer(String payerCode,String payerName,int pageNo,int pageSize);
	
	/**
	 * 获取总条数
	 * @return
	 */
	int getCount(String payerCode,String payerName);
	
	/**
	 * 根据id进行查询数据
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getTaxPayerInfoById(int id);
	
	/**
	 * 根据id删除信息
	 * @param id
	 * @return
	 */
	boolean deleteTaxPayerById(int id);
	
	/**
	 * 根据id获取要修改的信息
	 * @param id
	 * @return
	 */
	Map<String, String> updateTaxPayerById(int id);
	
	/**
	 * 修改信息
	 * @param tp
	 * @return
	 */
	boolean updateTaxPayerInfo(Taxpayer tp);
	
	/**
	 * 添加
	 * @param tp
	 * @return
	 */
	boolean addTaxPayer(Taxpayer tp);
}
