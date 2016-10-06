<div class="container-fluid" style="width: 1170px;">
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-md-12">
                <h3 class="gallery-title" style="text-align: left!important;">个人信息修改</h3>

            </div>
        </div>
        <div class="row">
            <form class="form-horizontal" role="form" action="saveupdate.html" method="post">
                <div class="form-group">
                    <label  class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="text" name="username" value="${session_username}" class="form-control"  placeholder="请输入用户名">
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">原密码</label>
                    <div class="col-sm-4">
                        <input type="text" name="password1" value="${session_password}" class="form-control"  placeholder="原密码">
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-4">
                        <input type="text" name="password" class="form-control"  placeholder="新密码">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-4">
                        <input type="text"  name="phone" value="${session_phone}" class="form-control"  placeholder="手机号">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>