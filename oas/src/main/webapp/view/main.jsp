<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<script type="text/javascript">
	function openTbs(title,url){
		if($("#tabs").tabs("exists",title)){
			$("#tabs").tabs("select",title);
		}else{
			var contents="<iframe scrolling='auto' src='"+url+"' style='width:100%;height:100%;' ></iframe> ";
			
			$("#tabs").tabs("add",{
				title:title,
				content:contents,
				closable:true		
			});
			
		}
	}

</script>
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:768px">
		<div region="north" split="true" style="height: 100px;width: 100%">
			顶部
		</div>
		<div region="west" split="true" title="导航菜单" style="width:150px;height:500px">
			<div class="easyui-accordion" style="width:150px;height:500px">
				<div title="公告管理">
					<a href="javascript:void(0);" onclick="openTbs('公告管理','notice.jsp');">公告管理</a><br>
					<a>学生管理</a>
				</div>
				<div title="用户管理">
					<a>员工管理</a><br>
					<a>学生管理</a>
				</div>
				<div title="用户管理">
					<a>员工管理</a><br>
					<a>学生管理</a>
				</div>
			</div>
		</div>
		<div region="center" style="height:500px">
			<div class="easyui-tabs" id="tabs" style="height:100%">
			
			</div>
		</div>
	</div>
</body>
</html>