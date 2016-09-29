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
      <h1 class="page-title">日志管理</h1>
     
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row">
            <div class="col-sm-12 col-md-6 col-lg-6">
              <!-- Example Horizontal Form --> 
              <h4 class="example-title" style="font-size: 20px!important;">查看用户日志：</h4>
                 <form class="form-horizontal" action="release.html" method="post" style="font-family:Roboto,sans-serif;font-size:18px;">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="demand_id" name="demand_id" placeholder="需求名" auto="" complete="off">
                         </div>
                    </div>
                    <div class="form-group">
                         <label class="col-sm-3 control-label">起始时间：</label>
                         <div class="col-sm-9">
                              <input class="form-control" type="datetime-local" name="demand_date" autocomplete="off">
                         </div>
                    </div>
                    <div class="form-group">
                         <label class="col-sm-3 control-label">截止时间：</label>
                         <div class="col-sm-9">
                              <input class="form-control" type="datetime-local" name="demand_date"  autocomplete="off">
                         </div>
                    </div>
                    <div class="form-group">
                         <div class="col-sm-9 col-sm-offset-3">
                              <button type="submit" style="float:right" class="btn btn-primary">提交 </button>
                         </div>
                    </div>
                </form>  
              <!-- End Example Horizontal Form -->
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
              <!-- Example Horizontal Form --> 
              <h4 class="example-title" style="font-size: 20px!important;">按时间查询日志：</h4>
                 <form class="form-horizontal" action="release.html" method="post" style="font-family:Roboto,sans-serif;font-size:18px;">
                    <div class="form-group">
                         <label class="col-sm-3 control-label">起始时间：</label>
                         <div class="col-sm-9">
                              <input class="form-control" type="datetime-local" name="demand_date" autocomplete="off">
                         </div>
                    </div>
                    <div class="form-group">
                         <label class="col-sm-3 control-label">截止时间：</label>
                         <div class="col-sm-9">
                              <input class="form-control" type="datetime-local" name="demand_date"  autocomplete="off">
                         </div>
                    </div>
                    <div class="form-group">
                         <div class="col-sm-9 col-sm-offset-3">
                              <button type="submit" style="float:right" class="btn btn-primary">提交 </button>
                         </div>
                    </div>
                </form>  
              <!-- End Example Horizontal Form -->
            </div>
          </div>
        </div>                    
      </div>
      <!-- pannel end-->
      <!-- pannel start-->
     
      <div class="panel">
      
      <header class="panel-heading">
          <div class="panel-actions"></div>
          <h3 class="panel-title">后台日志：</h3>
        </header>
      
      <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12"><div class="col-sm-12">
        </div><table class="table table-hover dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
           
           
           </table><table class="table table-hover dataTable table-striped width-full dtr-inline" id="exampleTableSearch" role="grid" aria-describedby="exampleTableSearch_info" style="width: 1229px;">
          <thead>
          <tr role="row">
            <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:200px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">用户名
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 200px;" aria-label="Position: activate to sort column ascending">密码
            </th>
            
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Start date: activate to sort column ascending">禁用
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Salary: activate to sort column ascending">恢复
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Salary: activate to sort column ascending">修改密码
            </th>
          </tr>    
          </thead>
          <tbody><tr class="odd">
              <td class="sorting_1">1</td> 
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
              
            </tr>
          
          
        </tbody></table>
      </div>
      
          </div></div><div class="row"><div class="col-sm-5"></div><div class="col-sm-7"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"><i class="icon wb-chevron-left-mini"></i></a></li><li class="paginate_button active"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">2</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">3</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="4" tabindex="0">4</a></li><li class="paginate_button "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="5" tabindex="0">5</a></li><li class="paginate_button next" id="DataTables_Table_0_next"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0"><i class="icon wb-chevron-right-mini"></i></a></li></ul></div></div></div></div>
      
      
        <header class="panel-heading">
          <div class="panel-actions"></div>
          <h3 class="panel-title">前台日志：</h3>
        </header>
        <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12"><table class="table table-hover dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
           
           
           <div class="col-sm-12">
        <table class="table table-hover dataTable table-striped width-full dtr-inline" id="exampleTableSearch" role="grid" aria-describedby="exampleTableSearch_info" style="width: 1229px;">
          <thead>
          <tr role="row">
            <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:200px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">用户名
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 200px;" aria-label="Position: activate to sort column ascending">密码
            </th>
            
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Start date: activate to sort column ascending">禁用
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Salary: activate to sort column ascending">恢复
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Salary: activate to sort column ascending">修改密码
            </th>
          </tr>    
          </thead>
          <tr class="odd">
              <td class="sorting_1">1</td> 
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
              
            </tr>
          
          
        </table>
      </div>
      
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