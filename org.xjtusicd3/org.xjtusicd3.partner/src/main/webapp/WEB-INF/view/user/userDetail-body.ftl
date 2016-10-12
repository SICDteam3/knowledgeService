<div class="container-fluid" style="width: 1170px;">
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-md-12">
                <h3 class="gallery-title" style="text-align: left!important;">用户详情：</h3>

            </div>
        </div>
        <div class="row">
            <form class="form-horizontal" role="form" >
                <div class="form-group">
                    <label  class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="text" name="username" value="${session_username}" class="form-control"  disabled="disabled" >
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-4">
                        <input type="text" name="password" value="${session_password}" class="form-control"  placeholder="原密码" disabled="disabled" >
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-4">
                        <input type="text" name="phone" value="${session_phone}" class="form-control"  placeholder="手机号" disabled="disabled" >
                    </div>
                </div>
              
            </form>
        </div>
    </div>