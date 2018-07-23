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
  </head>
  <body>
      <div class="container">
      	<table id="dg">
      	</table>
      <div id="tb" style="padding:0 30px;">
        纳税人识别号: <input type="text" name="payerCode" id="payerCode" style="width:166px;height:35px;line-height:35px;"/>
        纳税人名称: <input type="text" name="payerName" id="payerName" style="width:166px;height:35px;line-height:35px;"/>
      <a href="javascript:void(0);" id="searchBtn1" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a href="javascript:void(0);" id="setBtn1" class="easyui-linkbutton" iconCls="icon-reload">重置</a> 
      </div>
    </div>
  </body>
   <script type="text/javascript" src="${tx }static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${tx }static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${tx }static/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">     
           //查询
       	   function doSearch(){     	   
			   $("#dg").datagrid("load",{		
					"payerCode": $("#payerCode").val(),
					"payerName": $("#payerName").val()
				});
			}                                   
    </script>
    <script type="text/javascript">
        //为搜索按钮添加事件处理函数
        //为重置按钮添加事件处理函数
        //为添加纳税人添加事件处理函数
       
       //分页展示 吃石化页面
       $(function(){
       	   $("#dg").datagrid({
       	   title:"纳税人信息",
       	   url:"${tx }getStatisticalServlet.json",
       	   toolbar:"#tb",
       	   coolapsible:true,
       	   method:"POST",
       	   loadMsg:"数据加载中..",
       	   pagination:true,
       	   striped:true,  
       	   columns:[[
       	   	  		{field:"payerCode","title":"纳税人识别号"},
                    {field:"payerName","title":"纳税人名称"},
                    {field:"organName","title":"所属税务机关"},
                    {field:"industryName","title":"所属行业"},
                    {field:"legalPerson","title":"法人代表"},
                    {field:"legalIdCard","title":"法人身份证号码"},
                    {field:"finaceName","title":"主管财务"},
                    {field:"finaceIdCard","title":"财务身份证号码"},
                    {field:"recordDate","title":"录入日期"} 
              ]]           	          	   
       	   })
		   //查询事件
       	   $("#searchBtn1").on("click",function(){      	   
       	     doSearch()
       	   })
       	   //重置 
          $("#setBtn1").on("click",function(e){
           //文本框的内容清空
          	$("#payerCode").val("");           
          	$("#payerName").val("");           
          })     
       });
    </script>
    
</html>
