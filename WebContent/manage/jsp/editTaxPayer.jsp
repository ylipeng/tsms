<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>修改纳税人</title>
    <link href="${tx }static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="${tx }static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="${tx }static/easyui/uimaker/icon.css">
    <link href="${tx }static/css/edit.css" rel="stylesheet">

  </head>
  <body>
     <div class="container">
        <div class="content">
        <form id="editForm" method="post">
            <div title="纳税人信息" data-options="closable:false" class="basic-info">
                <div class="column"><span class="current">修改纳税人信息</span></div>
                
                <input name="id" id="id" type="hidden" value="${result.id }">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"><input type="text" name="payerCode" readonly value="${result.payerCode }" placeholder="纳税人识别号" ></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><input type="text" name="payerName" value="${result.payerName }" placeholder="纳税人名称" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><input type="text" name="bizAddress" value="${result.bizAddress }"  placeholder="生产经营地址" ></td>
                        <td class="kv-label">生成经营地电话</td>
                        <td class="kv-content"><input type="text" name="bizAddressPhone" value="${result.bizAddressPhone }" placeholder="生产经营地电话" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content">
                            <select name="taxOrganId" id="selectOrgan"> 
                            <c:if test="${result.taxOrganId==-1 }">
                            	<option value="-1" selected>请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>
                            <c:if test="${result.taxOrganId==1 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  selected>中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>
                            <c:if test="${result.taxOrganId==2 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  selected>北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==3 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  selected>天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==4 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  selected>上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==5 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  selected>深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==6 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  selected>武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==7 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  selected>杭州市国税局</option>
                            	<option value="8"  >郑州市国税局</option>
                            </c:if>	
                            <c:if test="${result.taxOrganId==8 }">
                            	<option value="-1">请选择所属税务机关</option>
								<option value="1"  >中国国税局</option>
                            	<option value="2"  >北京市国税局</option>
                            	<option value="3"  >天津市国税局</option>
                            	<option value="4"  >上海市国税局</option>
                            	<option value="5"  >深圳市国税局</option>
                            	<option value="6"  >武汉市国税局</option>
                            	<option value="7"  >杭州市国税局</option>
                            	<option value="8"  selected>郑州市国税局</option>
							</c:if>
                            </select>
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                            <select name="industryId" id="selectIndustry"> 
                            <c:if test="${result.industryId==-1 }">
                            	<option value="-1" selected>请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==1 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" selected>计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==2 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" selected>房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==3 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" selected>生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==4 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" selected>金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==5 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" selected>汽车工业</option>
                            	<option value="6" >通讯工程</option>
                            </c:if>
                            <c:if test="${result.industryId==6 }">
                            	<option value="-1">请选择行业</option>
                            	<option value="1" >计算机应用相关</option>
                            	<option value="2" >房地产</option>
                            	<option value="3" >生物医药</option>
                            	<option value="4" >金融</option>
                            	<option value="5" >汽车工业</option>
                            	<option value="6" selected>通讯工程</option>
                            </c:if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content">
                            <input type="text" name="bizScope" value="${result.bizScope }"  placeholder="生产经营范围">
                        </td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                            <select name="invoiceType">
                            <c:if test="${result.invoiceType=='-1' }">
                                <option value="-1" selected="selected">请选择发票种类</option>
                                <option value="增值税普通发票" >增值税普通发票</option>
                                <option value="增值税专用发票" >增值税专用发票</option>
                            </c:if>
                            <c:if test="${result.invoiceType=='增值税普通发票' }">
                                <option value="-1">请选择发票种类</option>
                                <option value="增值税普通发票" selected="selected">增值税普通发票</option>
                                <option value="增值税专用发票" >增值税专用发票</option>
                            </c:if>
                            <c:if test="${result.invoiceType=='增值税专用发票' }">
                                <option value="-1">请选择发票种类</option>
                                <option value="增值税普通发票" >增值税普通发票</option>
                                <option value="增值税专用发票" selected="selected">增值税专用发票</option>
                            </c:if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content">
                            <input type="text" name="legalPerson" value="${result.legalPerson }" placeholder="法人姓名">
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="legalIdCard" value="${result.legalIdCard }" placeholder="法人代表身份证号码">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content">
                            <input type="text" name="finaceName" value="${result.finaceName }" placeholder="主管财务">
                        </td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content">
                            <input type="text" name="finaceIdCard" value="${result.finaceIdCard }" placeholder="财务身份证号">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">录入人员</td>
                        <td class="kv-content">
                           <label>${result.tN }</label>
                        </td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content">${result.recordDate }</td>
                    </tr>
                    </tbody>                                
                </table>
               
            </div>
            <div class="btn-selection">
                <input type="submit" class="easyui-linkbutton submit-btn" id="editPayer" data-options="selected:true" value="修改">
                <input type="reset" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true">
            </div>
             </form>
        </div>
    </div>
  </body>
  <script type="text/javascript" src="${tx }static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${tx }static/easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="${tx }static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${tx }static/js/calendar.js"></script>
<script type="text/javascript">
    $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    }); 
    
    $(function(){
    	$("#editPayer").click(function(e){
    		var isValid = $('#editForm').form('validate');
			if(!isValid){
				return;
			}	
			e.preventDefault();
    		$.post(
    			"${tx }editTaxPayerServlet.json",
    			$("#editForm").serialize(),
    			function(data){
	    			if(data.success){
	       				parent.$.messager.alert({
	       					title:"提示",
	       					msg:data.msg
	       				})
	       				parent.$("#topWindow").window("close")
	     			}else{
	    				$.messager.alert({
		           			title:"提示",
		           			msg:data.msg
				        })
				     } 			
    			},
    			"json")    	    	
    	})
    	$("#reset").click(function(){
			$("#editForm").form("reset")
		})           
    })

    
   
</script>
</html>