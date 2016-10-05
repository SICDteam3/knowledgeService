<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign path="${rc.contextPath}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demanddetail</title>
 <#include "css.ftl">
 <style type="text/css">
          	.mytable{TABLE-LAYOUT: fixed;}
          	.mytable td {WORD-WRAP: break-word;overflow:hidded;}
          </style>
</head>
<body>
<#include "topbar.ftl">
<#include "menubar.ftl">
  <!-- Page -->
  <div class="page animsition">
	<div class="page-header">
      <h1 class="page-title">专利详情</h1>      
    </div>
    <div class="page-content">
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row row-lg">
            <div class="col-sm-12 col-md-6">
              <!-- Example Horizontal Form -->
              <div class="example-wrap">
                
                <div class="example" style="width:200%;">
                  <form class="form-horizontal" action="patentDetail.html" method="post">
                    <div class="form-group">
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label"  style="padding-left:40%;">专利名称：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label">${dc.name}</label>
                      </div>
                    </div>
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%;">专利编号：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label">${dc.number}</label>
                      </div>
                    </div>
                    
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%;">发明人：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label">${dc.patent_inventor}</label>
                      </div>
                    </div>
                   
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%; " >IPC：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label" style="text-align:left;WORD-WRAP: break-word;overflow:hidded;">${dc.IPC}</label>
                      </div>
                    </div>
                     <div class="form-group" >
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%;">申请日期：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class="control-label">${dc.date_of_application}</label>
                      </div>
                    </div>
                    
                    <div class="form-group">
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%;">申请地址：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class="control-label">${dc.address}</label>
                      </div>
                    </div>
                    
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="padding-left:40%; ">具体描述：</label>
                      </div>
                      <div class="col-sm-9" >               
                        <label class=" control-label" style="text-align:left; ">${dc.patent_abstract}</label>                                       
                      </div>
                    </div>
                     <div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
                      <button type="button" style="float:right"  onclick=" location.href='patentDelete.html?patentId=${dc.patentId}'"class="btn btn-primary">删除 </button>
                    
               		 </div>
                    </div>
                   
                  </form>
                </div>
               </div>
              <!-- End Example Horizontal Form -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Page -->

<#include "footer.ftl">
  <!-- Core  -->
<#include "scriptimport.ftl">

</body>
</html>