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
            <div class="col-sm-12 col-md-6">
              <!-- Example Horizontal Form --> 
              
              <form action="patentSearch.html" method="get">      
              <div class="example-wrap">
                <h4 class="example-title" style="font-size: 18px!important;">请输入搜索关键字和年份：</h4>
              <div class="form-group">
                  <div class="input-group">
                    <input type="text" class="form-control" name="queryKeyWord" placeholder="关键字">                   
                  </div>
                </div>               
                <div class="form-group">
                  <div class="input-group">                 
                    <input type="text" class="form-control" name="year" placeholder="年份">                    
                  </div>
                </div> 
                 <button type="submit"  class="btn btn-primary"><i class="icon wb-search" aria-hidden="true"></i></button>                           
      	       </div>
      	       </form>   
      	         
              <!-- End Example Horizontal Form -->
            </div>
          </div>
        </div>                    
      </div>
      <!-- pannel end-->
   
      <!-- pannel start-->
      <#if (listpatent??)>
      <div class="panel">
        <header class="panel-heading">
          <div class="panel-actions"></div>
          <h3 class="panel-title">搜索结果：</h3>
        </header>
        <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12"><table class="table table-hover dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
            <thead>
              <tr role="row"><th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 300px;" aria-label="Name: activate to sort column descending" aria-sort="ascending">标题</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;" aria-label="Position: activate to sort column ascending">发明人</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 250px;" aria-label="Office: activate to sort column ascending">申请机构</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 120px;" aria-label="Age: activate to sort column ascending">IPC</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 150px;" aria-label="Date: activate to sort column ascending">发行日期</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 120px;" aria-label="Salary: activate to sort column ascending">专利号</th>
              <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 120px;" aria-label="Salary: activate to sort column ascending">删除</th></tr>
            </thead>
            <tfoot>
              <tr><th rowspan="1" colspan="1">Name</th><th rowspan="1" colspan="1">Position</th><th rowspan="1" colspan="1">Office</th><th rowspan="1" colspan="1">Age</th><th rowspan="1" colspan="1">Date</th><th rowspan="1" colspan="1">Salary</th><th rowspan="1" colspan="1">专利详情</th></tr>
            </tfoot>
            <tbody> 
            <#list listpatent as patent>
            <tr role="row" class="odd">
                <td class="sorting_1" tabindex="0">${patent.title}</td>
                <td>${patent.inventor}</td>
                <td>${patent.applicant}</td>
                <td>${patent.IPC}</td>
                <td>${patent.publicationDate}</td>
                <td>${patent.publicationNumber}</td>               
                <td><a href="https://worldwide.espacenet.com${patent.detailLink}">删除</a></td>
              </tr>            
            </#list>            
            </tbody>
          </table></div></div><div class="row"><div class="col-sm-5"><div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 1 to 10 of 48 entries</div></div><div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"><i class="icon wb-chevron-left-mini"></i></a></li><li class="paginate_button active"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">2</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">3</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="4" tabindex="0">4</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="5" tabindex="0">5</a></li><li class="paginate_button next" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0"><i class="icon wb-chevron-right-mini"></i></a></li></ul></div></div></div></div>
        </div>
		</div>
		</#if>
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