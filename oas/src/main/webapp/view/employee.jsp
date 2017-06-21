<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<body>
	<form id="eform">
			<label>员工姓名：</label><input name="ename" id="queryename" class="easyui-textbox">
			<label>员工性别：</label><input name="esex" id="queryesex" class="easyui-textbox">
			<label>所属部门：</label><input name="department.dname" id="querydname" class="easyui-textbox">
			<label>所属职位：</label><input name="position.pname" id="querypname" class="easyui-textbox">
			<input type="button" id="query" value="查询">
		</form>
		<input type="button" value="修改" id="update">
		<input type="button" value="增加" id="add">
		<input type="button" value="删除" id="delete">
		<table id="table" class="easyui-datagrid" url="${pageContext.request.contextPath}/employee/doQuery.do" pagination="true" method="post">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
					<th field="did" style="display: none" ></th>
					<th field="enumber" width="80">员工编号</th>
					<th field="ename" width="80">员工姓名</th>
					<th field="esex" width="80">员工性别</th>
					<th field="eage" width="80">员工年龄</th>
					<th field="department" data-options="formatter:function(department){ return department.dname}" width="80">所属部门</th>
					<th field="position" data-options="formatter:function(position){ return position.pname}" width="80">所属岗位</th>
					<th field="salary" data-options="formatter:function(salary){ return salary.svalue}" width="80">薪资</th>
					<th field="etel" width="80">电话号码</th>
					<th field="eaddress" width="80">员工住址</th>
					<th field="eemail" width="80">电子邮箱</th>
					<th field="eentrydate" width="80">入职时间</th>
				</tr>
			</thead>
		</table>
		<div id="updateDlg" class="easyui-dialog" style="width:300px;" closed="true">
		<input type="hidden" id="saveUrl">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<input type="hidden" name="eid">
			<table align="center">
				<tr>
					<td><label>员工编号：</label></td>
					<td><input class="easyui-textbox" name="enumber" id="eenumber" data-options="readonly:'readonly', required:true"/></td>
				</tr>
				<tr>
					<td><label>员工姓名：</label></td>
					<td><input class="easyui-textbox" name="ename" id="eename" data-options="readonly:'readonly', required:true"/></td>
				</tr>
				<tr>
					<td><label>员工性别：</label></td>
					<td><input class="easyui-textbox" name="esex" id="eesex"  required="true"/></td>
				</tr>
				<tr>
					<td><label>员工年龄：</label></td>
					<td><input class="easyui-textbox" name="eage" id="eeage"  required="true"/></td>
				</tr>
				<tr>
					<td><label>所属部门：</label></td>
					<td><select id="edid" class="easyui-combobox" name="department.did" style="width:172px;" required="true" >
						    <option value="1">技术部</option>
						    <option value="2">人事部</option>
						    <option value="3">广告部</option>
						    <option value="4">保安部</option>
						</select></td>
				</tr>
				<tr>
					<td><label>所属岗位：</label></td>
					<td><select id="epid" class="easyui-combobox" name="position.pid" style="width:172px;" required="true" >
						    <option value="1">总经理</option>
						    <option value="2">经理</option>
						    <option value="3">主管</option>
						    <option value="4">员工</option>
						</select></td>
				</tr>
				<tr>
					<td><label>薪资：</label></td>
					<td><select id="esid" class="easyui-combobox" name="salary.sid" style="width:172px;" required="true" >
						    <option value="1">5000</option>
						    <option value="2">6000</option>
						    <option value="3">4000</option>
						    <option value="4">3000</option>
						</select></td>
				</tr>
				<tr>
					<td><label>电话号码：</label></td>
					<td><input class="easyui-textbox" name="etel" id="eetel"  required="true"/></td>
				</tr>
				<tr>
					<td><label>员工住址：</label></td>
					<td><input class="easyui-textbox" name="eaddress" id="eeaddress"  required="true"/></td>
				</tr>
				<tr>
					<td><label>电子邮箱：</label></td>
					<td><input class="easyui-textbox" name="eemail" id="eeemail"  required="true"/></td>
				</tr>
				<tr>
					<td><label>入职时间：</label></td>
					<td><input class="easyui-datetimebox" name="eentrydate" id="eeentrydate"  required="true"/></td>
				</tr>
			</table>
			
			<div id="update-dlg-btns" align="center">
				<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-ok" onclick="update();" style="width:100px;height:30px">保存</a>
					
				<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-cancel" onclick="closeDlg();" style="width:100px;height:30px">取消</a>
			</div>
		</form>
		
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
						ename:$("#queryename").val(),
						esex:$("#queryesex").val(),
						dname:$("#querydname").val(),
						pname:$("#querypname").val(),
						startDate:$("#start").val(),
						endDate:$("#end").val(),
				}
				//发送ajax请求
				$("#table").datagrid("reload",data);
				/* $.ajax({
					url:"${pageContext.request.contextPath}/employee/doQuery.do",
					type:"post",
					dataType:"json",
					data:data,
					success:function(respData){
						$("#table").datagrid("loadData",respData)
					}
					
				}); */
				
			}
		});
		
		$("#update").click(function(){
			//获取选中行，如果选中了多行，则获取的是第一个选中行
			var rows=$("#table").datagrid("getSelections");
			if(rows.length<1){
				alert("请选择要修改的行");
				return;
			}
			$("#eename").textbox({
				readonly:true
			});
			$("#updateDlg").dialog("open").dialog("setTitle","修改员工信息");
			$("#updateForm").form("load",rows[0]);
			$("#saveUrl").val("${pageContext.request.contextPath}/employee/doUpdate.do");
			/* 
			//1.为每一个输入框赋值
			$("#uusername").textbox("setValue",row.username);
			$("#uuserpwd").textbox("setValue",row.userpwd);
			$("#urealname").textbox("setValue",row.realname); */
			
			//直接将row里面的数据一次性赋值给有name属性的标签，并且name属性必须与row里面的属性想对应
			//$("#updateForm").form("load",row);
		})
		
		$("#add").click(function(){
			$("#updateForm").form("clear");
			$("#updateDlg").dialog("open").dialog("setTitle","增加员工信息");
			$("#eenumber").textbox({
				readonly:false,
				required:true
			});
			$("#eename").textbox({
				readonly:false,
				required:true
			});
			$("#saveUrl").val("${pageContext.request.contextPath}/employee/doInsert.do");
		});
		
		$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			if(rows.length>0){
				var idArr=new Array();
				$.each(rows,function(index,row){
					//将值放入数组里面
					idArr.push(row.eid);
				})
				
				$.ajax({
					url:"${pageContext.request.contextPath}/employee/doDelete.do",
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
					ename:$("#queryename").val(),
					esex:$("#queryesex").val(),
					dname:$("#querydname").val(),
					pname:$("#querypname").val(),
					startDate:$("#start").val(),
					endDate:$("#end").val(),
			}
			//发送ajax请求
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
</html>