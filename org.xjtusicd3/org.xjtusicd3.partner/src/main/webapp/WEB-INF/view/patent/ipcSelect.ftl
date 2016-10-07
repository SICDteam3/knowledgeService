<!DOCTYPE html>
<html>
<head>
	<#assign path="${rc.contextPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
 
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
</head>
<body>
<div class="contains">

	<select id="first-menu" class="form-control" onchange="selectSecondChild();">	  
	</select>	
	<select id="second-menu" class="form-control" onchange="selectThirdChild();">	  
	</select>	
	<select id="third-menu" class="form-control" onchange="selectForthChild();">	  
	</select>
	<select id="forth-menu" class="form-control" onchange="submitIPC();">	  
	</select>
</div>
</body>
<script>
$(document).ready(
	
   function(){
         $.ajax({
             type: "GET",
             url: "${path}/getFirstLevel.html",            
             dataType: "json",
             success: function(data){              	
             			 for(var i in data){ 
             			 	 document.getElementById("first-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });
    })
</script>
<script>
	function selectSecondChild(){
		var element = document.getElementById("first-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
             			 document.getElementById("second-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("second-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });         
	}
	
	function selectThirdChild(){
		var element = document.getElementById("second-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
            			 document.getElementById("third-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("third-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });         
	}
	
	function selectForthChild(){
		var element = document.getElementById("third-menu");
		var classId = element.options[element.selectedIndex].value;
		
		$.ajax({
             type: "GET",
             url: "${path}/getNextLevel.html"+"?"+"classId="+classId,            
             dataType: "json",
             success: function(data){
             		document.getElementById("forth-menu").options.length=0;              	
             			 for(var i in data){ 
             			 	 document.getElementById("forth-menu").options.add(new Option(data[i].cLASS_NAME, data[i].cLASS_ID));					        
					      }                                                                      
                      }
         });         
	}
	
	
	
</script>
</html>