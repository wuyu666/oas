<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path=request.getContextPath();
   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
<base href="${pageContext.request.contextPath}/">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript">
$(function(){
	//通过table标签得的一个分页插件
	var pp=$("#table").datagrid("getPager");	
	$(pp).pagination({			
		pageSize:10,
		pageList:[2,3,5,10],
		beforePageText:"第",	
		afterPageText:"页    共{pages}页",
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
		onSelectPage:function(curPage,pageSize){
			var data={
					curPage:curPage,
					pageSize:pageSize,
					nrange:$("#nrange").val(),
					startDate:$("#startDate").val(),
					endDate:$("#endDate").val(),
			}
			//发送ajax请求
			$("#table").datagrid("reload",data);
			<%-- $.ajax({
				url:"<%=basePath%>userServlet?cmd=queryUsers",
				type:"post",
				dataType:"json",
				data:data,
				success:function(respData){
					$("#table").datagrid("loadData",respData)
				}
				
			}); --%>
			
		}
	});
	
	$("#update").click(function(){
		var rows=$("#table").datagrid("getSelections");
	
		if(rows.length<1){
			alert("请选择要删除的行");
			return;
		}
		$("#updateDlg").dialog("open").dialog("setTitle","修改公告信息");
		$("#updateForm").form("load",rows[0]);
		$("#saveUrl").val("${pageContext.request.contextPath}/notice/updateNotice.do");
		
	})
	$("#add").click(function(){
		$("#updateForm").form("clear");
		$("#updateDlg").dialog("open").dialog("setTitle","增加公告信息");
		$("#saveUrl").val("${pageContext.request.contextPath}/notice/addNotice.do");
		
		//发送ajax请求添加
		/* $.ajax({
			url:$("#").val(),
			type:"post",
			dataType:"json",
			data:$("#updateForm").serialize(),
			success:function(resp){
				alert(resp.tip);
				$("#updateDlg").dialog("close");
				$("#table").datagrid("reload");
			}
		}); */
		
	});
	
	$("#delete").click(function(){
		var rows=$("#table").datagrid("getSelections");
		if(rows.length>0){
			var idArr=new Array();
			$.each(rows,function(index,row){
				//将值放入数组里面
				idArr.push(row.uid);
			})
			
			$.ajax({
				url:"${pageContext.request.contextPath}/notice/deleteNotice.do",
				type:"post",
				dataType:"json",
				data:{
					ids:idArr.toString()
				},
				success:function(data){
					//var json=eval("("+data+")");
					alert(data.tip);
					$("#table").datagrid("reload");
				}						
			})
		}else{
			alert("请选择要删除的数据");
		}
	})
	
	$("#query").click(function(){
		
		var data={
				curPage:$("#table").datagrid("getPager").pagination("options").pageNumber,
				pageSize:$("#table").datagrid("getPager").pagination("options").pageSize,
				nrange:$("#nrange").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val(),
		}
		//发送ajax请求
		/* $.ajax({
			url:"user/queryUsers.do",
			type:"post",
			dataType:"json",
			data:$("#queryForm").serialize(),
			success:function(resp){
				$("#table").datagrid("loadData",resp);
			}
		}); */
		
		$("#table").datagrid("load",data);
	})
})
function update(){

	$("#updateForm").form("submit",
			{
				url:$("#saveUrl").val(),
				onSubmit:function(){
			
					return $(this).form('validate');
				},
				success:function(data){
					var json=eval("("+data+")");
					alert(json.tip);
					$("#updateDlg").dialog("close");
					$("#table").datagrid("reload");
				}
		
			});
	
}
function closeDlg(){
	$("#updateForm").form("clear");
	$("#updateDlg").dialog("close");
}
</script>
</head>

</head>
<body>
	<form id="queryForm">
		<label>公告范围：</label><input class="easyui-textbox" name="nrange" id="nrange">
		
		<label>创建时间：</label><input
			class="easyui-datebox" name="startDate" id="startDate">
		-<input class="easyui-datebox" name="endDate" id="endDate">
	</form>
	<input type="button" value="查询" id="query">
	<input type="button" value="修改" id="update">
	<input type="button" value="增加" id="add">
	<input type="button" value="删除" id="delete">
	<table id="table" class="easyui-datagrid"  
	url="${pageContext.request.contextPath}/notice/queryNotice.do" pagination="true"  method="post">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="nid" width="80">公告ID</th>
				<th field="nrange"  width="80">公告范围</th>
				<th field="ntheme"  width="80">公告主题</th>
				<th field="ncontent"  width="280">公告内容</th>
				<th field="ntime"  width="80">创建公告时间</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="updateDlg" class="easyui-dialog" style="width:300px;height:300px" closed="true">
		<input type="hidden" id="saveUrl">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<input type="hidden" name="id">
			<table align="center">
				<tr>
					<td><label>创建时间：</label></td>
					<td><input class="easyui-datetimebox"  name="ntime"  id="ntime" required="true"/></td>
				</tr>
				<tr>
					<td><label>公告范围：</label></td>
					<td><select name="nrange" class="easyui-combobox"
                            id="nrange" style="width: 154px;" editable="false"
                            panelHeight="auto">
                                <option value="">请选择公告范围</option>
                                <option value="技术部">技术部</option>
                                <option value="销售部">销售部</option>
                                <option value="财务部">财务部</option>
                                <option value="人事部">人事部</option>
                                <option value="全公司">全公司</option>
                        </select></td>
				</tr>
				
				<tr>
					<td><label>公告主题：</label></td>
					<td><input class="easyui-textbox" name="ntheme" id="ntheme"  required="true"/></td>
				</tr>
				<tr>
					<td><label>公告内容：</label></td>
					<td><input class="easyui-textbox" name="ncontent"  id="ncontent" required="true" style="height:100px"/></td>
				</tr>
				
				
			</table>
			
			<div id="update-dlg-btns" align="center">
				<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-ok" onclick="update();" style="width:100px;height:30px" >保存</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-cancel" onclick="closeDlg();" style="width:100px;height:30px">取消</a>
			</div>
		</form>
		
	</div>
	
</body>
</html>