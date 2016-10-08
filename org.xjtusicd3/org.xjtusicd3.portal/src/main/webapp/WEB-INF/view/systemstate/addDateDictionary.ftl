<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">

  <title>数据字典</title>

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
      <h1 class="page-title">新增数据字典</h1>
      <div class="page-header-actions">
        <button type="button" class="btn btn-sm btn-icon btn-default btn-outline btn-round" onclick=" location.href='search.html'"
           data-toggle="tooltip" >返回</button>
      </div>
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row row-lg">
            <div class="col-sm-12 col-md-12">
            <!-- Example Horizontal Form --> 
              <h4 class="example-title" style="font-size: 18px!important;">请输入数据名称与数据值：</h4>
                 <form class="form-horizontal" action="data_dictionary.html" method="get" style="font-family:Roboto,sans-serif;font-size:18px;">
                    <div class="form-group">
                        <div class="col-sm-3">
                           <input type="text" class="form-control" name="dictionaryName" placeholder="数据名称" auto="" complete="off">
                         </div>
                         <div class="col-sm-3">
                          <input type="text" class="form-control" name="dictrionaryValue" placeholder="数据值"> 
                         </div>                    
                         <div class="col-sm-3">
                           <button type="submit" style="float:left" class="btn btn-primary" >提交 </button>
                         </div>
                    </div>                  
                </form>  
              <!-- End Example Horizontal Form -->
             
            </div>
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
     $("#ipc").click(function(){
 
         var ipc=decument.getElementById("ipc").value;
         
         $.ajax({
             type:"get",
             url: "patent/patentDelete.html"+ipc,
             dataType:'json',
             success:{
             alert("result");
             }
         })
         
    
    
    }
    



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