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
      <h1 class="page-title">修改个人信息</h1>
      <div class="page-header-actions">
        <button type="button" class="btn btn-sm btn-icon btn-default btn-outline btn-round"
        data-toggle="tooltip" data-original-title="Edit">
          <i class="icon wb-pencil" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-sm btn-icon btn-default btn-outline btn-round"
        data-toggle="tooltip" data-original-title="Refresh">
          <i class="icon wb-refresh" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-sm btn-icon btn-default btn-outline btn-round"
        data-toggle="tooltip" data-original-title="Setting">
          <i class="icon wb-settings" aria-hidden="true"></i>
        </button>
      </div>
    </div>
    <div class="page-content">
      <div class="panel">
        <div class="panel-body container-fluid">
          <div class="row row-lg">
            <div class="col-sm-12 col-md-6">
              <!-- Example Horizontal Form -->
              <div class="example-wrap">
                
                <div class="example">
                  <form class="form-horizontal" action="saveupdate.html" method="post">
                    <div class="form-group">
                      <label class="col-sm-3 control-label">用户名:</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" name="username" value="${viewUser.username}" placeholder="Full Name" autocomplete="off"
                        />
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">密码:</label>
                      <div class="col-sm-9">
                        <input type="password" class="form-control" name="password" value="${viewUser.password}" placeholder="Full Name" autocomplete="off"
                        />
                      </div>
                    </div>
                    <input  type="hidden"  name="status" value="${viewUser.status}"/>
                    
                    <#if viewUser.status=="s2"||viewUser.status=="s1">
                    <div class="form-group">
                      <label class="col-sm-3 control-label">真实姓名:</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" name="truename" value="${viewUser.truename}" placeholder="真实姓名" autocomplete="off"
                        />
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">手机号</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" name="phoneNumber" value="${viewUser.phoneNumber}" placeholder="手机号" autocomplete="off"
                        />
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">银行卡号:</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" name="bankNumber" value="${viewUser.bankNumber}" placeholder="银行卡号" autocomplete="off"
                        />
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">身份证号:</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" name="idNumber" value="${viewUser.idNumber}" placeholder="身份证号" autocomplete="off"
                        />
                      </div>
                    </div>
                    </#if>
                    <div class="form-group">
                      <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary">保存 </button>
                        <button type="reset" class="btn btn-default btn-outline">重置</button>
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