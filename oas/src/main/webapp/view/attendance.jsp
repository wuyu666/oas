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
<script type="text/javascript">
 	var da=new Date();
	function formatDay(date){		
		var m = date.getMonth()+1;//得到日历中每个月份各有几天	
		var d = date.getDate();//得到日历中的每天
		var opts = $(this).calendar('options');
		//opts.month当前月份的天数
		if (opts.month == m && d < da.getDate()){
			return '<div class="icon-ok md">' + d + '</div>';
		}
		return d;
	}
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                + " " + date.getHours() + seperator2 + date.getMinutes()
                + seperator2 + date.getSeconds();
        var a=$("nowtime").val("123");
        alert(a);
    }
</script>
<style scoped="scoped">
		.md{
			height:16px;
			line-height:16px;
			background-position:2px center;
			text-align:right;
			font-weight:bold;
			padding:0 2px;
			color:red;
		}
</style>
<body>	
		<span>所有员工上、下班都需要打下班卡。规定上班时间为<span style="color: red">9:00</span>,超过15分钟以内不算迟到。</span><br>
		<span>下班时间为<span style="color: red">18:00</span>提前打下班卡视为旷工。</span>
		<div class="easyui-calendar" firstDay="1" style="width:670px;height:400px;" 
		data-options="formatter:formatDay"></div>
		<input type="hidden" id="nowtime">
		<input type="button" value="打卡" onclick="getNowFormatDate()" id="upbtn" name="upbtn">
	
</body>
</html>