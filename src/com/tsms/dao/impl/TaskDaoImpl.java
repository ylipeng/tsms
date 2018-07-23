package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaskDao;
import com.tsms.entity.Taxsource;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaskDaoImpl implements TaskDao{
	
	private DBUtil db = DBUtil.getInstance();

	private List<Map<String, String>>  list;
	
	private Map<String, String> result;
	
	private String sql = "";

	/**
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, String> getTaxPayerById(int id) {
		sql = "select *,ta.taxerName tN from tb_tax_payer p join tb_tax_organ o join tb_user u join tb_taxer ta join tb_industry i on p.taxOrganId=o.id and p.userId=u.taxerId and u.taxerId = ta.id and p.industryId=i.id where  p.id=? ";
		list = db.query(sql, id);
		result = list.get(0);
		return result;
	}

	/**
	 * 根据payerCode获取信息
	 * @param payerCode
	 * @return
	 */
	@Override
	public Map<String, String> getTaxPayerByPayerCode(String payerCode) {
		sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_user u join tb_taxer ta join tb_industry i on p.taxOrganId=o.id and p.userId=u.taxerId and u.taxerId = ta.id and p.industryId=i.id where  p.payerCode=? ";
		list = db.query(sql, payerCode);
		result = list.get(0);
		return result;
	
	}
	
	

	/**
	 * 添加
	 * @param ts
	 * @return
	 */
	@Override
	public boolean addTaxsource(Taxsource ts) {
		sql = "insert into tb_tax_source (payerId,taskName,subOrganId,approverId,executeId,executeTime,taskState,recordTaskDate) values (?,?,?,?,?,?,?,?)";
		Object [] params = {ts.getPayerId(),ts.getTaskName(),ts.getSubOrganId(),ts.getApproverId(),ts.getExecuteId(),ts.getExecuteTime(),ts.getTaskState(),ts.getRecordTaskDate()};
		boolean b = db.update(sql, params);
		return b;
	}

	/**
	 * 分页查询已录入调查的信息
	 * @param payerCode
	 * @param payerName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Map<String, String>> getListTaxsource(String payerCode,String payerName,int subOrganId,int industryId,String startDate,String endDate,int pageNo,int pageSize) {
		sql = "select * from tb_tax_source s join tb_tax_payer p join tb_industry i on s.payerId=p.id and p.industryId=i.id where p.removeState=0 and s.removeState=0 ";
		if(StringUtil.isNotBlank(payerCode)){
			sql += " and p.payerCode="+payerCode;
		}
		if(StringUtil.isNotBlank(payerName)){
			sql +=" and p.payerName='"+payerName+"'";
		}
		if(subOrganId!=-1){
			sql+=" and s.subOrganId="+subOrganId;
		}
		if(industryId!=-1){
			sql+=" and p.industryId="+industryId;
		}
		if(StringUtil.isNotBlank(startDate) && StringUtil.isNotBlank(endDate)){
			sql+=" and s.executeTime between '"+startDate+"' and '"+endDate+"'";
		}
		sql +=" limit ?,?";
		list = db.query(sql,(pageNo-1)*pageSize,pageSize);
		return list;
	}

	
	/**
	 * 获取已录入调查的总条数
	 * @return
	 */
	@Override
	public int getCount(String payerCode,String payerName,int subOrganId,int industryId,String startDate,String endDate) {
		sql = "select count(*) cou from tb_tax_source s join tb_tax_payer p on s.payerId=p.id where s.removeState=0";
		if(StringUtil.isNotBlank(payerCode)){
			sql += " and p.payerCode="+payerCode;
		}
		if(StringUtil.isNotBlank(payerName)){
			sql +=" and p.payerName='"+payerName+"'";
		}
		if(subOrganId!=-1){
			sql+=" and s.subOrganId="+subOrganId;
		}
		if(industryId!=-1){
			sql+=" and p.industryId="+industryId;
		}
		if(StringUtil.isNotBlank(startDate) && StringUtil.isNotBlank(endDate)){
			sql+=" and s.executeTime between '"+startDate+"' and '"+endDate+"'";
		}
		list = db.query(sql);
		return Integer.parseInt(list.get(0).get("cou"));
	}

	/**
	 * 查询未被调查的信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Map<String, String>> getListNotTask(String payerCode,String payerName,int pageNo,int pageSize) {
		if(payerCode!=null && payerCode!="" || payerName!=null && payerName!=""){
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id"
					+ " where p.id in (select p.id from tb_tax_payer p left join tb_tax_source s on p.id = s.payerId where s.payerId is null) and (p.payerCode=? or p.payerName=?) and p.removeState=0 limit ?,?";
			list = db.query(sql,payerCode,payerName,(pageNo-1)*pageSize,pageSize);
		}else{
			sql = "select * from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id"
					+ " where p.id in (select p.id from tb_tax_payer p left join tb_tax_source s on p.id = s.payerId where s.payerId is null) and p.removeState=0 or p.payerCode=? or p.payerName=?    limit ?,?";
			list = db.query(sql,payerCode,payerName,(pageNo-1)*pageSize,pageSize);
		}
		return list;
	}

	/**
	 * 获取未被录入调查的总条数
	 * @return
	 */
	@Override
	public int getNotTaskCount() {
		sql = "select count(*) cou from tb_tax_payer p left join tb_tax_source s on p.id = s.payerId where s.payerId is null and p.removeState=0";
		list = db.query(sql);
		return Integer.parseInt(list.get(0).get("cou"));
	}

	/**
	 * 根据id删除
	 */
	@Override
	public boolean deleteTask(int id) {
		sql = "update tb_tax_source set removeState = 1 where id=?";
		Object [] params = {id};
		boolean b = db.update(sql, params);
		return b;
	}

	
	/**
	 * 根据id查询要修改的信息
	 */
	@Override
	public Map<String, String> getUpdateTaskById(int id) {
		sql = "select * from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_user u join tb_taxer ta join tb_industry i on s.payerId=p.id and p.taxOrganId=o.id and p.userId=u.id and u.taxerId = ta.id and p.industryId=i.id where  s.id=?";
		result = db.queryOneRow(sql, id);
		return result;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateTask(Taxsource ts) {
		sql = "update tb_tax_source set subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=? where id=? and payerId=?";
		Object [] params = {ts.getSubOrganId(),ts.getApproverId(),ts.getExecuteId(),ts.getExecuteTime(),ts.getTaskState(),ts.getId(),ts.getPayerId()};
		boolean b = db.update(sql, params);
		return b;
	}

	

}
