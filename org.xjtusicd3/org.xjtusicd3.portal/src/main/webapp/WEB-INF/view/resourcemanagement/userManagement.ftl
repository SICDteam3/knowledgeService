<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">

  <title>用户管理</title>

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
      <h1 class="page-title">用户管理</h1>
     
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row" >
            <div class="col-sm-12 col-md-6 col-lg-6">
              <!-- Example Horizontal Form --> 
              <form action="userSearch3.html" method="get">      
              <div class="example-wrap">
                <h4 class="example-title" style="font-size: 18px!important;">请输入用户名：</h4>
                    <div class="form-group">
                  <div class="input-group">
                    <input type="text" class="form-control" name="name" placeholder="请输入用户名...">
                    <span class="input-group-btn">
                      <button type="submit" class="btn btn-primary"><i class="icon wb-search" aria-hidden="true"></i></button>
                    </span>
                  </div>
                </div>                      
      	       </div>
      	       </form>     
              <!-- End Example Horizontal Form -->
            </div>
            
             <div class="col-sm-12 col-md-6 col-lg-6" >
              <!-- Example Horizontal Form --> 
              <form action="userBlack.html" method="get">      
              	<div class="example-wrap">
        			<div class="form-group">
                    	<input onclick="userBlack"  type="submit" class="btn btn-primary" style="float: right;margin-top: -28px;" value="查看黑名单">                             
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
          <h3 class="panel-title">搜索结果 ：</h3>
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
             <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:200px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">邮箱
            </th>
             <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:200px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">用户类型
            </th>
             <th class="sorting_asc" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width:200px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">电话号码
            </th>
           
            
            <th class="sorting" tabindex="0" aria-controls="exampleTableSearch" rowspan="1" colspan="1" style="width: 50px;" aria-label="Salary: activate to sort column ascending">详情
            </th>
          </tr>    
          </thead>
          <tbody>
          <#list patentPage.results as us>
          <tr class="odd">
              <td class="sorting_1">${us.username}</td> 
              <td>${us.password}</td>
               <td>${us.email}</td>
               <td>${us.type}</td>
               <td>${us.phone}</td>
             
                <td><a href="http://localhost:8080/org.xjtusicd3.portal/user/toUserDetail.html?userId=${us.idNumber}">详情</a></td>
            </tr>  
            </#list>                 
        </tbody></table>
      </div>    
       <nav>
              <span style="display: inline-block;float: left;width: 80px;margin-top: 27px;margin-left: 30px;">总共 ${patentPage.totalPage} 页</span>
			  <ul class="pagination pagination-md">
			  <#list patentPage.pageNo-5 .. patentPage.pageNo+8 as t>
				<#if (t lt patentPage.totalPage+1)&&(t gt 0)>
			    <li <#if t=patentPage.pageNo>class="active"</#if>><a href="searchpage.html?name=${name}&&currentpage=${t}">${t}</a></li>  
			   	</#if>
			   </#list>
			  </ul>
			</nav>    
     
       
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