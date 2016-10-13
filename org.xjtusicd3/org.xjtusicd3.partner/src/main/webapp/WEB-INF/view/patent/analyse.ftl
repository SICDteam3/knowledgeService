<!DOCTYPE html>
<html>
<head>
	<#assign path="${rc.contextPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>西安交通大学社会智能实验室</title>

    <meta name="robots" content="INDEX,FOLLOW">
    <meta name="keywords" content="专利分析">
    <meta name="description" content="西安交通大学社会智能实验室知识服务小组 专利分析">

    <link rel="stylesheet" type="text/css" media="screen" href="${path}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${path}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/xxzl.css">
    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/echarts3.min.js"></script>
	 <script src="${path}/js/vintage.js"></script>
	 <script src="http://d3js.org/d3.v3.min.js"></script>
</head>
<body>
	<#include "header.ftl">
	<#include "patent/analyse-body.ftl">
	<#include "footer.ftl">
</body>
</html>