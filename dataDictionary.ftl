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
      <h1 class="page-title">数据字典</h1>
     
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div>
           <input onclick="userBlack"  type="submit" class="btn btn-primary" style="float:right;margin-top: 1%;margin-right:2%" value="新增">                             
        </div>
      <header class="panel-heading">
          <div class="panel-actions"></div>
          <h3 class="panel-title">数据字典详情 ：</h3>
        </header>
      
      <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12"><div class="col-sm-12">
        </div><table class="table table-hover dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
           
           
           </table><table class="table table-hover dataTable table-striped width-full dtr-inline" id="exampleTableSearch" role="grid" aria-describedby="exampleTableSearch_info" style="width: 1229px;">
          <thead>
          <tr role="row">
            <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:40%;" aria-sort="ascending" aria-label="Name: activate to sort column descending">数据名称
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 40%;" aria-label="Position: activate to sort column ascending">数据值
            </th>
            
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:5%;" aria-label="Start date: activate to sort column ascending">删除
            </th>
           
          </tr>    
          </thead>
          <tbody><tr class="odd">
              <td class="sorting_1">${us.username}</td> 
              <td>${us.password}</td>
              <td><a href="http://localhost:8080/org.xjtusicd3.portal/patent/patentDetail.html?patentId=${patent.patentId}">删除</a></td>
             
            </tr>                   
        </tbody></table>
      </div>    
          </div></div><div class="row"><div class="col-sm-5"></div><div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"><i class="icon wb-chevron-left-mini"></i></a></li><li class="paginate_button active"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">2</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">3</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="4" tabindex="0">4</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="5" tabindex="0">5</a></li><li class="paginate_button next" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0"><i class="icon wb-chevron-right-mini"></i></a></li></ul></div></div></div></div>
       </div>
       
      </div>
       <!-- pannel start-->
     
      
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