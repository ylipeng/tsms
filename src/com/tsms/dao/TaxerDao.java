package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxer;

public interface TaxerDao {
	
	/**
	 * 分页展示所有信息
	 * @return
	 */
	List<Map<String, String>> getListTaxer(String taxerName,int pageNo,int pageSize);
	
	/**
	 * 获取信息数量
	 * @return
	 */
	int getTaxerCount(String taxerName);
	
	/**
	 * 根据id获取详情
	 * @param id
	 * @return
	 */
	Map<String, String> getTaxerInfoById(int id);
	
	/**
	 * 根据id删除信息
	 * @param id
	 * @return
	 */
	boolean deleteTaxer(int id);
	
	/**
	 * 修改
	 * @return
	 */
	boolean updateTaxer(Taxer ta);
	
	/**
	 * 添加
	 * @param ta
	 * @return
	 */
	boolean addTaxer(Taxer ta);

}
