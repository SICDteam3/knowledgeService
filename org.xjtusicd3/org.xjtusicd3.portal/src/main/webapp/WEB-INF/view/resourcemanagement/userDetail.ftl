<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign path="${rc.contextPath}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>专利详情</title>
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
      <h1 class="page-title">用户详情</h1>
       <div class="page-header-actions">
        <button type="button" class="btn btn-sm btn-icon btn-default btn-outline btn-round" onclick=" location.href='userSearch3.html?name=${us.username}'"
           data-toggle="tooltip" >返回</button>
      </div>      
    </div>
    <div class="page-content">
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row row-lg">
            <div class="col-sm-12 col-md-6">
              <!-- Example Horizontal Form -->
              <div class="example-wrap">
                
                <div class="example" style="width:200%;">
                  <form class="form-horizontal" action="pswAlter.html" method="get">
                  
                    <div class="form-group">
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%">用户名：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label" >${us.username}</label>
                      </div>
                    </div>
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%" >用户编号：</label>
                      </div>
                      <div class="col-sm-9">
                        <label  class=" control-label">${us.idNumber}</label>
                      </div>
                    </div>
                    
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%" >邮箱：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label">${us.email}</label>
                      </div>
                    </div>
                   
                    <div class="form-group">
                    <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%">用户类型：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class=" control-label" style="text-align:left;WORD-WRAP: break-word;overflow:hidded;">${us.type}</label>
                      </div>
                    </div>
                     <div class="form-group" >
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%">电话号码：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class="control-label">${us.phone}</label>
                      </div>
                    </div>
                    
                    <div class="form-group">
                     <div class="col-sm-3" style="width:12%;">
                      <label class=" control-label" style="margin-left:40%">密码：</label>
                      </div>
                      <div class="col-sm-9">
                        <label class="control-label">${us.password}</label>
                      </div>
                    </div>
                    
                    
                    
                     <div class="form-group">
                      <div class="col-sm-3" style="display:none;">
                          <input name="userId" value=${us.idNumber}>                    
                      </div>
                     <div class="col-sm-3" style="width:12%;" id="changeButton">
                      <button type="button" style="float:right;"  onclick="$('#changeButton').hide();$('#inputPassword').show();$('#submitButton').show();" class="btn btn-primary">修改密码 </button>
                      </div>
                      
                       <div class="col-sm-3" id="inputPassword" style="display:none;">
                          <input name="password" />                    
                      </div>
                       <div class="col-sm-3" id="submitButton" style="display:none;">
                           <button type="submit" style="float:left;"  onclick=""class="btn btn-primary">提交新密码</button>                    
                      </div>
                    </div>
                  
                    
                     <div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
                    <button type="button" style="float:right"  onclick=" location.href='http://localhost:8080/org.xjtusicd3.portal/user/defriend.html?userId=${us.idNumber}'"class="btn btn-primary">拉黑</button>
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