package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxsource;

public interface TaskDao {

	/**
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	Map<String, String> getTaxPayerById(int id);
	
	/**
	 * 根据payerCode获取信息
	 * @param payerCode
	 * @return
	 */
	Map<String, String> getTaxPayerByPayerCode(String payerCode);
	
	/**
	 * 添加
	 * @param ts
	 * @return
	 */
	boolean addTaxsource(Taxsource ts);
	
	/**
	 * 分页查询已录入调查的信息
	 * @param payerCode
	 * @param payerName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getListTaxsource(String payerCode,String payerName,int subOrganId,int industryId,String startDate,String endDate,int pageNo,int pageSize);
	
	
	/**
	 * 获取已录入调查的总条数
	 * @return
	 */
	int getCount(String payerCode,String payerName,int subOrganId,int industryId,String startDate,String endDate);
	
	/**
	 * 查询未被调查的信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getListNotTask(String payerCode,String payerName,int pageNo,int pageSize);
	
	/**
	 * 获取伟被录入调查的总条数
	 * @return
	 */
	int getNotTaskCount();
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	boolean deleteTask(int id);
	
	/**
	 * 根据id获取要修改的信息
	 * @param id
	 * @return
	 */
	Map<String, String> getUpdateTaskById(int id);
	
	/**
	 * 修改
	 * @param ts
	 * @return
	 */
	boolean updateTask(Taxsource ts);
}
