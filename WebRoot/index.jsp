<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>${party.title}</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/index.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="body">
		<div class="item">
			<div class="label">发起人</div>
			<div class="content">${creator.nickname}</div>
		</div>
		<div class="item">
			<div class="label">活动时间</div>
			<div class="content">${party.startTime}</div>
		</div>
		<div class="item">
			<div class="label">集合地点</div>
			<div class="content">${party.gatheringPlace}</div>
		</div>
		<c:forEach items="${invitedMembers}" var="account">
			<div class="invitedMembers" style="background-image: url('${account.avatar.mid}')"></div>
		</c:forEach>
		
    	<c:forEach items="${party.activities}" var="activity">
		<div class="item">
			<div class="label">活动：</div>
			<div class="content">${activity.activityTitle}</div>
		</div>
		</c:forEach>
		<div class="item">
			<a href="http://192.168.23.1:8080/PartyTimeWeb/app/PartyTime.apk" id="download">下载会聚客户端</a>
		</div>
	</div>
</body>
</html>
