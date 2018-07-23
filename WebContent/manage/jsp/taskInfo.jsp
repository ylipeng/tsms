<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务录入</title>
    <link href="${tx }static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="${tx }static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="${tx }static/easyui/uimaker/icon.css">
    <link href="${tx }static/css/edit.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="content">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">纳税人基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">纳税人识别号</td>
                    <td class="kv-content"><label>${result.payerCode }</label></td>
                    <td class="kv-label">纳税人名称</td>
                    <td class="kv-content">${result.payerName }</td>
                    <td class="kv-label">生产经营地址</td>
                    <td class="kv-content">${result.bizAddress }</td>
                </tr>
                <tr>
                    <td class="kv-label">所属税务机关</td>
                    <td class="kv-content">${result.organName }</td>
                    <td class="kv-label">行业</td>
                    <td class="kv-content">${result.industryName }</td>
                    <td class="kv-label">经营范围</td>
                    <td class="kv-content">${result.bizScope }</td>
                </tr>
                <tr>
                    <td class="kv-label">票种核定</td>
                    <td class="kv-content">${result.invoiceType }</td>
                    <td class="kv-label">法人代表人</td>
                    <td class="kv-content">${result.legalPerson }</td>
                    <td class="kv-label">法人身份证号</td>
                    <td class="kv-content">${result.legalIdCard }</td>
                </tr>
                <tr>
                    <td class="kv-label">主管财务</td>
                    <td class="kv-content">${result.finaceName }</td>
                    <td class="kv-label">财务身份证号</td>
                    <td class="kv-content">${result.finaceIdCard }</td>
                </tr>
                <tr>
                    <td class="kv-label">录入日期</td>
                    <td class="kv-content">${result.recordDate }</td>
                    <td class="kv-label">录入人</td>
                    <td class="kv-content">${result.username }</td>
                </tr>
                </tbody>
            </table>
            <div class="column"><span class="current">任务信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">任务名称</td>
                    <td class="kv-content"><label>${result.taskName }</label></td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content">
                    	<label>
                    	<c:if test="${result.subOrganId==1 }">
                    		中国国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==2 }">
                    		北京市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==3 }">
                    		天津市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==4 }">
                    		上海市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==5 }">
                    		深圳市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==6 }">
                    		武汉市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==7 }">
                    		杭州市国税局
                    	</c:if>
                    	<c:if test="${result.subOrganId==8 }">
                    		郑州市国税局
                    	</c:if>
                    	</label>
                    </td>
                    <td class="kv-label">批准人</td>
                    <td class="kv-content">
                    	<label>
                    	<c:if test="${result.approverId==1 }">
                    		章莉
                    	</c:if>
                    	<c:if test="${result.approverId==2 }">
                    		程维
                    	</c:if>
                    	<c:if test="${result.approverId==3 }">
                    		金霉瓶
                    	</c:if>
                    	<c:if test="${result.approverId==4 }">
                    		彭丽媛
                    	</c:if>
                    	<c:if test="${result.approverId==5 }">
                    		admin
                    	</c:if>
                    	</label>
                    </td>
                </tr>
               
                <tr>
                	<td class="kv-label">执行人</td>
                    <td class="kv-content">
                    	<label>
                    	<c:if test="${result.executeId==1 }">
		                    	章莉
	                    </c:if>
                    	<c:if test="${result.executeId==2 }">
		                    	程维
	                    </c:if>
                    	<c:if test="${result.executeId==3 }">
		                    	金霉瓶
	                    </c:if>
                    	<c:if test="${result.executeId==4 }">
		                    	彭丽媛
	                    </c:if>
                    	<c:if test="${result.executeId==5 }">
		                    	admin
	                    </c:if>
                    	</label>
                    </td>
                 	<td class="kv-label">执行时间</td>
                    <td class="kv-content"><label>${result.executeTime }</label></td>
                    
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3" readonly style="width: 90%;">${result.taskState }</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
                      
    </div>
</div>
  </body>
</html>