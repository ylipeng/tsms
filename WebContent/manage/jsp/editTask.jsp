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
      <form id="editTask" method="post">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">纳税人基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">纳税人识别号</td>
                    <td class="kv-content"><input type="text" readonly value="${result.payerCode }" name="payerCode" ></td>
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
          
            <input type="hidden" name="id" value="${result.id }">
            <input type="hidden" name="payerId" value="${result.payerId }" >
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">任务名称</td>
                    <td class="kv-content"><input type="text" readonly value="${result.taskName }" name="taskName" ></td>
                    <td class="kv-label">下达部门</td>
                    <td class="kv-content">  
                     <select name="subOrganId" id="selectOrgan" >
                     <c:if test="${result.subOrganId==-1 }">
	                     <option value="-1" selected="selected">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==1 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" selected="selected">中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==2 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" selected="selected">北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==3 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" selected="selected">天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==4 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" selected="selected">上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==5 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" selected="selected">深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==6 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" selected="selected">武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==7 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" selected="selected">杭州市国税局</option>
	                     <option value="8" >郑州市国税局</option>
	                 </c:if> 
                     <c:if test="${result.subOrganId==8 }">
	                     <option value="-1">请选择下达部门</option>
	                     <option value="1" >中国国税局</option>
	                     <option value="2" >北京市国税局</option>
	                     <option value="3" >天津市国税局</option>
	                     <option value="4" >上海市国税局</option>
	                     <option value="5" >深圳市国税局</option>
	                     <option value="6" >武汉市国税局</option>
	                     <option value="7" >杭州市国税局</option>
	                     <option value="8" selected="selected">郑州市国税局</option>
	                 </c:if> 
                     </select>
					</td>
                    <td class="kv-label">批准人</td>
                    <td class="kv-content">
                     <select name="approverId">
                     <c:if test="${result.approverId==-1 }">
	                     <option value="-1" selected>请选择批准人</option>
	                     <option value="1" >章莉</option>
	                     <option value="2" >程维</option>
	                     <option value="3" >金霉瓶</option>
	                     <option value="4" >彭丽媛</option>
	                     <option value="5" >admin</option>
                     </c:if>
                     <c:if test="${result.approverId==1 }">
	                     <option value="-1">请选择批准人</option>
	                     <option value="1" selected>章莉</option>
	                     <option value="2" >程维</option>
	                     <option value="3" >金霉瓶</option>
	                     <option value="4" >彭丽媛</option>
	                     <option value="5" >admin</option>
                     </c:if>
                     <c:if test="${result.approverId==2 }">
	                     <option value="-1">请选择批准人</option>
	                     <option value="1" >章莉</option>
	                     <option value="2" selected>程维</option>
	                     <option value="3" >金霉瓶</option>
	                     <option value="4" >彭丽媛</option>
	                     <option value="5" >admin</option>
                     </c:if>
                     <c:if test="${result.approverId==3 }">
	                     <option value="-1">请选择批准人</option>
	                     <option value="1" >章莉</option>
	                     <option value="2" >程维</option>
	                     <option value="3" selected>金霉瓶</option>
	                     <option value="4" >彭丽媛</option>
	                     <option value="5" >admin</option>
                     </c:if>
                     <c:if test="${result.approverId==4 }">
	                     <option value="-1">请选择批准人</option>
	                     <option value="1" >章莉</option>
	                     <option value="2" >程维</option>
	                     <option value="3" >金霉瓶</option>
	                     <option value="4" selected>彭丽媛</option>
	                     <option value="5" >admin</option>
                     </c:if>
                     <c:if test="${result.approverId==5 }">
	                     <option value="-1">请选择批准人</option>
	                     <option value="1" >章莉</option>
	                     <option value="2" >程维</option>
	                     <option value="3" >金霉瓶</option>
	                     <option value="4" >彭丽媛</option>
	                     <option value="5" selected>admin</option>
                     </c:if>
                     </select>
					</td>
                </tr>
              
                <tr>  
               		<td class="kv-label">执行人</td>
                  	<td class="kv-content">    	
	                    <select name="executeId">
	                    <c:if test="${result.executeId==-1 }">
		                    <option value="-1" selected>请选择执行人</option>
		                    <option value="1" >章莉</option>
		                    <option value="2" >程维</option>
		                    <option value="3" >金霉瓶</option>
		                    <option value="4" >彭丽媛</option>
		                    <option value="5" >admin</option>
	                    </c:if>
	                    <c:if test="${result.executeId==1 }">
		                    <option value="-1">请选择执行人</option>
		                    <option value="1" selected>章莉</option>
		                    <option value="2" >程维</option>
		                    <option value="3" >金霉瓶</option>
		                    <option value="4" >彭丽媛</option>
		                    <option value="5" >admin</option>
	                    </c:if>
	                    <c:if test="${result.executeId==2 }">
		                    <option value="-1">请选择执行人</option>
		                    <option value="1" >章莉</option>
		                    <option value="2" selected>程维</option>
		                    <option value="3" >金霉瓶</option>
		                    <option value="4" >彭丽媛</option>
		                    <option value="5" >admin</option>
	                    </c:if>
	                    <c:if test="${result.executeId==3 }">
		                    <option value="-1">请选择执行人</option>
		                    <option value="1" >章莉</option>
		                    <option value="2" >程维</option>
		                    <option value="3" selected>金霉瓶</option>
		                    <option value="4" >彭丽媛</option>
		                    <option value="5" >admin</option>
	                    </c:if>
	                    <c:if test="${result.executeId==4 }">
		                    <option value="-1">请选择执行人</option>
		                    <option value="1" >章莉</option>
		                    <option value="2" >程维</option>
		                    <option value="3" >金霉瓶</option>
		                    <option value="4" selected>彭丽媛</option>
		                    <option value="5" >admin</option>
	                    </c:if>
	                    <c:if test="${result.executeId==5 }">
		                    <option value="-1">请选择执行人</option>
		                    <option value="1" >章莉</option>
		                    <option value="2" >程维</option>
		                    <option value="3" >金霉瓶</option>
		                    <option value="4" >彭丽媛</option>
		                    <option value="5" selected>admin</option>
	                    </c:if>
	                    </select>
                 	</td>
                	<td class="kv-label">执行时间</td>
                    <td class="kv-content"><input type="text"  name="executeTime"  value="${result.executeTime } "></td>
                    <td class="kv-label">任务执行情况</td>
                    <td class="kv-content">
                        <textarea rows="3" name="taskState" style="width: 90%;">${result.taskState }</textarea>
                    </td>
                  
                </tr>
                </tbody>
            </table> 
                 
        </div>
        <div class="btn-selection">
            <input type="submit" class="easyui-linkbutton submit-btn" id="saveBtn" data-options="selected:true" value="保存">
            <input type="reset" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true" value="重置">
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
  //保存
    $(function(){
    	$("#saveBtn").click(function(e){
    		var isValid = $('#editForm').form('validate');
			if(!isValid){
				return;
			}	
			e.preventDefault();
    		$.post(
    			"${tx }editTaskServlet.json",
    			$("#editTask").serialize(),
    			function(data){
    			if(data.success){
       				parent.$.messager.alert({
       					title:"提示",
       					msg:data.msg,
       				}) 
       				parent.$("#topWindow").window("close")
     			}else{
    				$.messager.alert({
           				title:"提示",
          			 	msg:data.msg,
        			})
     			}
    		},"json")
    	})
    	//重置
    	$("#reset").click(function(){
			$("#editTask").form("reset")
		}) 
    })

</script>
</html>
