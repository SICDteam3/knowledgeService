<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">

  <title>日志管理</title>

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
            <div class="col-sm-12 col-md-12 col-lg-12">
              <!-- Example Horizontal Form --> 
              <h4 class="example-title" style="font-size: 18px!important;">查看用户日志：</h4>
                 <form class="form-horizontal" action="logSearch.html" method="get" style="font-family:Roboto,sans-serif;font-size:18px;">
                    <div class="form-group">
                        <div class="col-sm-3">
                           <input type="text" name="name" class="form-control" id="userName" placeholder="用户名" auto="" complete="off">
                         </div>
                         <div class="col-sm-3">
                           <input class="form-control" type="date" name="StartTime" id="beginning"  placeholder="起始时间" auto="" complete="off">
                         </div>
                         <div class="col-sm-3">
                           <input class="form-control" type="date" name="EndTime"  id="deadline"  placeholder="截止时间" auto="" complete="off">
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
     
      
    
 
  <!-- End Page -->
  
   <!-- pannel start-->
     
      <div class="panel-body">
          <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-12"><div class="col-sm-12">
        </div><table class="table table-hover dataTable table-striped width-full dtr-inline" data-plugin="dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="width: 1280px;">
           
           
           </table><table class="table table-hover dataTable table-striped width-full dtr-inline" id="exampleTableSearch" role="grid" aria-describedby="exampleTableSearch_info" style="width: 1229px;">
          <thead>
          <tr role="row">
            <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:30%;" aria-sort="ascending" aria-label="Name: activate to sort column descending">用户名
            </th>
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 30%;" aria-label="Position: activate to sort column ascending">操作
            </th>       
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 30%;" aria-label="Start date: activate to sort column ascending">请求参数
            </th> 
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 30%;" aria-label="Start date: activate to sort column ascending">请求ip
            </th>    
          </tr>    
          </thead>
          <tbody> 
          <#list patentPage.results as log>
          <tr class="odd">
              <td class="sorting_1">${log.userName}</td> 
              <td>${log.operation}</td>
              <td>${log.argument}</td>
              <td>${log.ip}</td>
            </tr>
          </#list>
          
        </tbody>
        
        </table>
         <nav>
              <span style="display: inline-block;float: left;width: 6%;margin-top: 3%;margin-left: 40%;">总共 ${patentPage.totalPage} 页</span>
			  <ul class="pagination pagination-md">
			  <#list patentPage.pageNo-5 .. patentPage.pageNo+8 as t>
				<#if (t lt patentPage.totalPage+1)&&(t gt 0)>
			    <li <#if t=patentPage.pageNo>class="active"</#if>><a href="searchpage.html?name=${name}&&currentpage=${t}&&StartTime=${StartTime}&&EndTime=${EndTime}">${t}</a></li>  
			   	</#if>
			   </#list>
			  </ul>
			</nav> 
      </div>
      
     </div> 
     </div>
     </div> 
      <!-- pannel end-->
      
    </div>
  </div>
  <!-- End Page -->
 </div> 


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