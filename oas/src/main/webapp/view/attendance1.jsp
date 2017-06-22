<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path=request.getContextPath();
   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					astate:$("#astate").val(),
					startDate:$("#startDate").val(),
					endDate:$("#endDate").val(),
			}
			$("#table").datagrid("reload",data);			
		}
	});
	
	$("#update").click(function(){
		var rows=$("#table").datagrid("getSelections");
	
		if(rows.length<1){
			$.messager.alert("系统提示", "请选择要修改的数据！");
			return;
		}
		$("#updateDlg").dialog("open").dialog("setTitle","修改考勤信息");
		$("#updateForm").form("load",rows[0]);
		$("#saveUrl").val("${pageContext.request.contextPath}/attendance/updateAtt.do");
		
	})
	$("#add").click(function(){
		$("#updateForm").form("clear");
		$("#updateDlg").dialog("open").dialog("setTitle","增加考勤信息");
		$("#saveUrl").val("${pageContext.request.contextPath}/attendance/addAtt.do");		
	});
	

	$("#delete").click(function(){
        var selectedRows = $("#table").datagrid("getSelections");
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].aid);
        }
        var ids = strIds.join(",");
        alert(ids)
        $.messager.confirm("系统提示", "您确定要删除这<font color=red>"
                + selectedRows.length + "</font>条数据吗？", function(r) {
            if (r) {
                $.post("${pageContext.request.contextPath}/attendance/deleteAtt.do", {
                    ids : ids
                }, function(result) {
                    if (result.success) {
                        $.messager.alert("系统提示", "数据删除失败，请联系系统管理员！");
                    } else {
                        $.messager.alert("系统提示", "数据已成功删除！");
                        $("#table").datagrid("reload");
                      //relod跟load一样有加载数据功能，也一样的传参数，但它传给后台的分布信息是当前的页码，就是实现刷新当前页的功能。
                    }
                }, "json");
            }
        });
    })
	$("#query").click(function(){
		
		var data={
				curPage:$("#table").datagrid("getPager").pagination("options").pageNumber,
				pageSize:$("#table").datagrid("getPager").pagination("options").pageSize,
				astate:$("#astate1").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val(),
		}
		
		
		$("#table").datagrid("load",data);
	})
})
function update(){
	$("#updateForm").form("submit",
			{
				url:$("#saveUrl").val(),
				onSubmit:function(){
//在使用combobox时id和name不能设置为一样的值，否则不能正确对应
					if ($("#astate1").combobox("getValue") == "") {
				        $.messager.alert("系统提示", "请选择状态！");
				        return false;
				    }
					return $(this).form('validate');
				},
				success:function(data){
					var json=eval("("+data+")");
					$.messager.alert("系统提示", json.tip);
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
		<label>状态：</label><input class="easyui-textbox" name="astate" id="astate">
		
		<label>时间：</label><input
			class="easyui-datebox" name="startDate" id="startDate">
		-<input class="easyui-datebox" name="endDate" id="endDate">
		<a href="javascript:void(0);" class="easyui-linkbutton"
                iconCls="icon-search" plain="true" id="query">查询</a>
	</form>
	<a href="javascript:void(0);" class="easyui-linkbutton"
            iconCls="icon-add" plain="true" id="add">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true" id="update">修改</a>
    <a href="javascript:void(0);" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true" id="delete">删除</a>  
                          
	<table id="table" class="easyui-datagrid"  
	url="${pageContext.request.contextPath}/attendance/queryAtt.do" pagination="true"  method="post">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="aid" width="100">考勤ID</th>
				<th field="auptime"  width="100">上班时间</th>
				<th field="adowntime"  width="100">下班时间</th>
				<th field="astate"  width="100">状态</th>
				
				
			</tr>
		</thead>
	</table>
	
	<div id="updateDlg" class="easyui-dialog" style="width:300px;height:300px" closed="true">
		<input type="hidden" id="saveUrl">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<input type="hidden" name="nid">
			<table align="center">
				<tr>
					<td><label>考勤ID：</label></td>
					<td><input class="easyui-textbox"  name="aid"  id="aid" required="true"/></td>
				</tr>
				<tr>
					<td><label>上班时间：</label></td>
					<td><input class="easyui-textbox" name="auptime" id="auptime"  required="true"/></td>
				</tr>
				<tr>
					<td><label>下班时间：</label></td>
					<td><input class="easyui-textbox" name="adowntime"  id="adowntime" required="true"/></td>
				</tr>
				<tr>
					<td><label>状态：</label></td>
					<td><select name="astate" class="easyui-combobox"
                            id="astate1" style="width: 154px;" editable="false"
                            panelHeight="auto">
                                <option value="">请选择状态</option>
                                <option value="0">正常</option>
                                <option value="1">迟到</option>
                                <option value="2">旷工</option>
                                <option value="3">请假</option>
                                
                        </select></td>
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