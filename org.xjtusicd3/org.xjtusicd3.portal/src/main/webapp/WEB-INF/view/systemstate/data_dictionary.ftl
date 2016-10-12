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
        <form class="form-horizontal" action="toDictionary.html" method="get">
        <div>
          <a >"</a>
           <input   type="submit" class="btn btn-primary" style="float:right;margin-top: 1%;margin-right:2%" value="新增">                          
        </div>
        </form>
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
          <tbody>
              <#list patentPage.results as ds>
              <tr class="odd">
              <td class="sorting_1">${ds.dictionaryName}</td> 
              <td>${ds.dictionaryValue}</td>
              <td><a href="http://localhost:8080/org.xjtusicd3.portal/data_Dictionary/deleteDictionary.html?dictionaryId=${ds.dictionaryId}&&currentpage=${patentPage.pageNo}">删除</a></td>
             
            </tr> 
             </#list>                    
        </tbody></table>
     
      <nav>
              <span style="display: inline-block;float: left;width: 6%;margin-top: 3%;margin-left: 40%;">总共 ${patentPage.totalPage} 页</span>
			  <ul class="pagination pagination-md">
			  <#list patentPage.pageNo-5 .. patentPage.pageNo+8 as t>
				<#if (t lt patentPage.totalPage+1)&&(t gt 0)>
			    <li <#if t=patentPage.pageNo>class="active"</#if>><a href="searchpage.html?content=${content}&&currentpage=${t}&&searchtype=${searchtype}">${t}</a></li>  
			   	</#if>
			   </#list>
			  </ul>
			</nav>    
      </div>
       <!-- pannel start-->
     </div>
     </div></div></div></div> 
   
  <!-- End Page -->


  <#include "footer.ftl">
  <!-- Core  -->
  <#include "scriptimport.ftl">
</body>
<script src="/knowledge/js/jquery-1.7.2.min.js"></script>
<script>
	
</script>
</html>