<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">

  <title>专利管理</title>

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
      <h1 class="page-title">专利管理</h1>
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row row-lg">
            <div class="col-sm-12 col-md-12">
            <!-- Example Horizontal Form --> 
              <h4 class="example-title" style="font-size: 18px!important;">请输入搜索关键字和年份：</h4>
                 <form class="form-horizontal" action="patentSearch.html" method="get" style="font-family:Roboto,sans-serif;font-size:18px;">
                    <div class="form-group">
                        <div class="col-sm-3">
                           <input type="text" class="form-control" name="patentName" placeholder="关键字" auto="" complete="off">
                         </div>
                         <div class="col-sm-3">
                          <input type="text" class="form-control" name="patentTime" placeholder="年份"> 
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
   
      <!-- pannel start-->
     
    
        <header class="panel-heading">
          <div class="panel-actions"></div>
          <h3 class="panel-title">搜索结果：</h3>
        </header>
        <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12">
          <style type="text/css">
          	.mytable{TABLE-LAYOUT: fixed;}
          	.mytable td {WORD-WRAP: break-word;overflow:hidded;}
          </style>
          <table class="table table-hover mytable dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
            <thead>
              <tr role="row">
              <th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 35%;" aria-label="Name: activate to sort column descending" aria-sort="ascending">标题</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 35%;" aria-label="Position: activate to sort column ascending">发明人</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 35%;" aria-label="Office: activate to sort column ascending">IPC</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 15%;" aria-label="Age: activate to sort column ascending">申请日期</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width:15%;" aria-label="Date: activate to sort column ascending">发行日期</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width:15%;" aria-label="Salary: activate to sort column ascending">专利号</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width:10%;" aria-label="Salary: activate to sort column ascending">详情</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 10%;" aria-label="Salary: activate to sort column ascending">删除</th>
              </tr>
            </thead>
            
            <tbody> 
            <#list lp as patent>
            <tr role="row" class="odd">
                <td class="sorting_1" tabindex="0">${patent.name}</td>
                <td>${patent.patent_inventor}</td>           
                <td id="ipc">${patent.IPC}</td>
                <td style="width: 120px">${patent.date_of_application}</td>
                <td style="width: 120px">${patent.announcement_date}</td>
                <td>${patent.patentId}</td>
                <td><a href="http://localhost:8080/org.xjtusicd3.portal/patent/patentDetail.html?patentId=${patent.patentId}">详情</a></td>               
                <td><a href="http://localhost:8080/org.xjtusicd3.portal/patent/patentDelete.html?patentId=${patent.patentId}">删除</a></td>
              </tr>            
            </#list>            
            </tbody>
          </table></div></div><div class="row"><div class="col-sm-5"></div><div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"><i class="icon wb-chevron-left-mini"></i></a></li><li class="paginate_button active"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">2</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">3</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="4" tabindex="0">4</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="5" tabindex="0">5</a></li><li class="paginate_button next" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0"><i class="icon wb-chevron-right-mini"></i></a></li></ul></div></div></div></div>
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