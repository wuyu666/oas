<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门查询</title>
</head>
<body>
	<div>
		<form id="dform">
			<label>部门名称：</label><input name="dname" id="dname" class="easyui-textbox">
			<input type="button" id="queryBtn" value="查询">
		</form>
		<input type="button" value="修改" id="updateBtn">
		<input type="button" value="增加" id="addBtn">
		<input type="button" value="删除" id="deleteBtn">
		<table id="table" class="easyui-datagrid" url="${pageContext.request.contextPath}/department/doQuery" pagination="true" method="post">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
					<th field="did" style="display: none" ></th>
					<th field="dnumber" width="80">部门编号</th>
					<th field="dname" width="80">部门名称</th>
					<th field="pname" width="80">职位</th>
				</tr>
			</thead>
		</table>
	</div>
	<div>
		
	</div>
</body>
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
					username:$("#dname").val(),
			}
			//发送ajax请求
			//$("#table").datagrid("reload",data);
			$.ajax({
				url:"${pageContext.request.contextPath}/department/doQuery.do",
				type:"post",
				dataType:"json",
				data:data,
				success:function(respData){
					$("#table").datagrid("loadData",respData)
				}
			});
			
		}
	});
	$("#queryBtn").click(function(){
		var data={
				curPage:$("#table").datagrid("getPager").pagination("options").pageNumber,
				pageSize:$("#table").datagrid("getPager").pagination("options").pageSize,
				username:$("#dname").val(),
		}
		//发送ajax请求
		//$("#table").datagrid("load",data);
		$.ajax({
			url:"${pageContext.request.contextPath}/department/doQuery.do",
			type:"post",
			dataType:"json",
			data:data,
			success:function(respData){
				$("#table").datagrid("loadData",respData)
			}
		});
	})
	
})

</script>
</html>