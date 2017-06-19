<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'notive1.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript"
    src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    var url;
    function searchNrange() {
//load的参数为一个json对象，里面写的是你要传输的参数的键值对，调用这个方法来加载数据的时候，它传给后台的分页信息是从第一页开始的。
        $("#dg").datagrid('load', {
            "nrange" : $("#s_nrange").val()
        });
    }
    function openNoticeAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加公告");
        url = "${pageContext.request.contextPath}/notice/save.do";
    }

    function openNoticeModifyDialog() {
        var selectedRows = $("#dg").datagrid("getSelections");
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "编辑公告信息");
        $("#fm").form("load", row);
        url = "${pageContext.request.contextPath}/notice/save.do?id=" + row.id;
    }
    
    function saveNotice() {
        $("#fm").form("submit", {
            url : url,
            onSubmit : function() {
                if ($("#nrange").combobox("getValue") == "") {
                    $.messager.alert("系统提示", "请选择公告范围！");
                    return false;
                }
                return $(this).form("validate");//true提交表单，false不提交
            },
            success : function(result) {
                var result = eval('(' + result + ')');
                if (result.success) {
                    $.messager.alert("系统提示", "保存成功！");
                    resetValue();
                    $("#dlg").dialog("close");
                    $("#dg").datagrid("reload");
                } else {
                    $.messager.alert("系统提示", "保存失败！");
                    return;
                }
            }
        });
    }

    function resetValue() {
        $("#nrange").combobox("setValue", "");
        $("#ntheme").val("");
        $("#ncontent").val("");
        $("#ntime").datebox("setValue", "");
    }

    function closeNoticeDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }

    function deleteNotice() {
        var selectedRows = $("#dg").datagrid("getSelections");
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].id);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确定要删除这<font color=red>"
                + selectedRows.length + "</font>条数据吗？", function(r) {
            if (r) {
                $.post("${pageContext.request.contextPath}/notice/delete.do", {
                    ids : ids
                }, function(result) {
                    if (result.success) {
                        $.messager.alert("系统提示", "数据已成功删除！");
                        $("#dg").datagrid("reload");
//relod跟load一样有加载数据功能，也一样的传参数，但它传给后台的分布信息是当前的页码，就是实现刷新当前页的功能。
                    } else {
                        $.messager.alert("系统提示", "数据删除失败，请联系系统管理员！");
                    }
                }, "json");
            }
        });
    }
</script>
</head>

<body style="margin: 1px">

    <table id="dg" title="公告管理" class="easyui-datagrid" fitColumns="true"
        pagination="true" rownumbers="true"
        url="${pageContext.request.contextPath}/notice/doSelect.do" fit="true"
        toolbar="#tb">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="nid" width="80">公告ID</th>
				<th field="nrange"  width="80">公告范围</th>
				<th field="ntheme"  width="80">公告主题</th>
				<th field="ncontent"  width="280">公告内容</th>
				<th field="ntime"  width="80">创建公告时间</th>
                
            </tr>
        </thead>
    </table>
    <div id="tb">
        <a href="javascript:openNoticeAddDialog()" class="easyui-linkbutton"
            iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:openNoticeModifyDialog()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteNotice()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
        <div>
            &nbsp;公告范围：&nbsp;<input type="text" id="s_nrange" size="20"
                onkeydown="if(event.keyCode == 13)searchUser()" /> <a
                href="javascript:searchNrange()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">查询</a>
        </div>

        <div id="dlg-buttons">
            <a href="javascript:saveNotice()" class="easyui-linkbutton"
                iconCls="icon-ok">保存</a> <a href="javascript:closeNoticeDialog()"
                class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
        </div>

        <div id="dlg" class="easyui-dialog"
            style="width: 730px;height:280px;padding:10px 10px;" closed="true"
            buttons="#dlg-buttons">
            <form method="post" id="fm">
                <table cellspacing="8px;">
                    <tr>
                        <td>创建时间：</td>
                        <td><input type="text" id="ntime" name="ntime"
                            class="easyui-datebox" required="true" />&nbsp;<span
                            style="color: red">*</span>
                        </td>
                        <td>&nbsp;&nbsp;</td>
                        <td>范围：</td>
                        <td><select name="nrange" class="easyui-combobox"
                            id="nrange" style="width: 154px;" editable="false"
                            panelHeight="auto">
                                <option value="">请选择公告范围</option>
                                <option value="技术部">技术部</option>
                                <option value="销售部">销售部</option>
                                <option value="财务部">财务部</option>
                                <option value="人事部">人事部</option>
                                <option value="全公司">全公司</option>
                        </select> &nbsp;<span style="color: red">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>主题：</td>
                        <td><input type="text" id="ntheme" name="ntheme"
                            class="easyui-validatebox" required="true" />&nbsp;<span
                            style="color: red">*</span>
                        </td>
                        <td>&nbsp;&nbsp;</td>
                        <td>内容：</td>
                        <td><input type="password" id="ncontent" name="ncontent"
                            class="easyui-textbox" data-options="multiline:true" value="在此输入文本内容" style="width:300px;height:100px"/>&nbsp;<span
                            style="color: red">*</span>
                        </td>
                    </tr>
                    
                </table>
            </form>
        </div>
</body>
</html>