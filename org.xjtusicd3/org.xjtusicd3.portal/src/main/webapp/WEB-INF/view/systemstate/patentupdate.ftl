<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">

  <title>Dashboard | Remark Admin Template</title>

  <#include "css.ftl">
</head>
<body class="dashboard" style="font-family: 'Arial','Hiragino Sans GB', \5fae\8f6f\96c5\9ed1, 'Helvetica', 'sans-serif';">
  <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
  <#include "topbar.ftl">
  <#include "menubar.ftl">
  <!-- Page -->
  <div class="page animsition">
	<div class="page-header">
      <h1 class="page-title">在线人数</h1>    
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
         
        </div>                    
      </div>
      <!-- pannel end-->
      
      <!-- pannel start--> 
     <div class="panel">
 		<div class="panel-body">
        
      	</div>   
	</div>
      <!-- pannel end-->
      
    </div>
  </div>
  <!-- End Page -->


  <#include "footer.ftl">
  <!-- Core  -->
  <#include "scriptimport.ftl">
</body>
<script src="/knowledge/js/jquery-1.7.2.min.js"></script>
<script>
	function submitquery(){
		
		var keyword = document.getElementById("queryKeyword").value;
		alert(keyword);
		$.ajax({
			type: "get",
			url: "query.html?query="+keyword,
			dataType:'json',
			success: function(result){
				alert(result);
			},
			error: function(){
				alert("错误！");
				return false;
			}
	 });
				
	};
	
	function printTable(){}
</script>
</html>