<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>纳税人管理</title>
    <link href="${tx }static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="${tx }static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="${tx }static/easyui/uimaker/icon.css">
    <link rel="stylesheet" href="${tx }static/css/taxpayer.css">
    <style type="text/css">
	.a{
		text-decoration: none;
	}
</style>
  </head>
  <body>
      <div class="container">
      	<table id="dg">
      	</table>
      <div id="tb" style="padding:0 30px;">
        纳税人识别号: <input type="text" name="payerCode" id="payerCode" style="width:166px;height:35px;line-height:35px;"/>
        纳税人名称: <input type="text" name="payerName" id="payerName" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
        <a href="javascript:void(0);" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加纳税人</a>
      </div>
    </div>
</body>
<script type="text/javascript" src="${tx }static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${tx }static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${tx }static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
         /**
            *打开在父窗口中打开window
            */
function openTopWindow(options){
	options = !options ? {} :options;
	options.width = !options.width ? 500 : options.width;
	options.height = !options.height ? 400 : options.height;
	options.title = !options.title ? "" : options.title;
	parent.$("#iframe").attr("src",options.url);
	parent.$("#topWindow").window({
		title : options.title,
		width: options.width,
		height: options.height,
		modal:true,
		resizable:true,
		collapsible:false,
	});           
}
         
//详情
function detail(id){	          
	openTopWindow({
		url:"${tx }getTaxPayerInfoServlet.json?id="+id,
		title:"纳税人信息",	   		 	
		width : 750,
		height : 500,
	})
// 	doSearch()	           	          
}

//删除
function removeTaxPayer(id) {
	 $.messager.confirm('操作提示', '确定要删除吗?', 
		function(r){
			if (r){
				$.post(
					"${tx }deleteTaxPayerServlet.json",
					"id="+id+"",
					function(data){
		           		if(data.success){
		           			alert(data.msg)
		           			doSearch()	
		           		}else{
		           			alert(data.msg)
		           		}
	           		},
	           		"json")
	           	doSearch()	     
			}
	   });

} 

//修改
function edit(id){	          
	openTopWindow({
		url:"${tx }toEditTaxPayerServlet.json?id="+id,
		title:"修改纳税人信息",	   		 	
		width : 750,
		height : 600,
	})
// 	doSearch()      	          
} 
	
//查询
function doSearch() {
	$("#dg").datagrid("load",{		
		payerCode: $("#payerCode").val(),
		payerName: $("#payerName").val()
	});
}
//新建任务
function addTask(id){ 
		parent.addTab("调查任务录入","${tx }toAddTaskServlet.json?id="+id)                     		
}


$(function() {
			
	$("#dg").datagrid({
		title:"纳税人信息",
		url:"${tx }listTaxPayerServlet.json",
		toolbar:"#tb",
		coolapsible:true,
		method:"POST",
		loadMsg:"数据加载中..",
		pagination:true,
		striped:true,  
		columns:[[
			{field:"payerCode",title:"纳税人识别号"},
			{field:"payerName",title:"纳税人名称"},
			{field:"organName",title:"所属税务机关"},
			{field:"industryName",title:"所属行业"},
			{field:"legalPerson",title:"法人代表"},
			{field:"legalIdCard",title:"法人身份证号码"},
			{field:"finaceName",title:"主管财务"},
			{field:"finaceIdCard",title:"财务身份证号码"},
			{field:"recordDate",title:"录入日期"},  
			{field:"opreation",title:"操作",formatter:function(value,rowData,index){
				return "<a href='javascript:void(0)' onclick='detail("+rowData.id+")'>详情   </a>"
						+"<a href='javascript:void(0)' onclick='removeTaxPayer("+rowData.id+")'>删除   </a>"
						+"<a href='javascript:void(0)' onclick='edit("+rowData.id+")'>修改   </a>"
						+"<a href='javascript:void(0)' id='addTask' onclick='addTask("+rowData.id+")'>新建任务 </a>"                               
			}}   
		]]      	          	   
	})
	
	//查询
	$("#searchBtn").click(function() {
		doSearch()
	})
      
	 //重置 
    $("#setBtn").click(function(e){
    //文本框的内容清空
    	$("#payerCode").val("");           
    	$("#payerName").val("");           
    })


    //添加页面事件
 	$("#addBtn").click(function(e){
        openTopWindow({
            width : 750,
            height : 600,
            title : "新增纳税人",
            url : "${tx }manage/jsp/addTaxPayer.jsp"
        });
        doSearch()
    });

})

         
         
</script>
</html>