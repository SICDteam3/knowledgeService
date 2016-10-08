<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid" style="width: 1170px;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${path}/index.html">xxzl</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${path}/forum/forumlist.html">资讯</a></li>
                <li><a href="${path}/patent/companymap.html">企业地图</a></li>
                <li><a href="#">专家地图</a></li>
                <li class="dropdown">
                    <a href="${path}/patent/analyse.html" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">专利服务 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${path}/patent/analyse.html">专利可视化</a></li>

                        <li class="divider"></li>
                        <li><a href="${path}/patent/analyse.html">专利地图</a></li>
                        <li class="divider"></li>
                    </ul>
                </li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
            <#if session_username??>
                <li><a href="${path}/user/userDetail.html">${session_username}</a></li>
                <li class="dropdown">
                    <a href="${path}/patent/analyse.html" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">我的账户<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${path}/user/userDetail.html">个人信息</a></li>

                        <li class="divider"></li>
                        <li><a href="${path}/user/userDetail.html">信息修改</a></li>
                        <li class="divider"></li>
                         <li><a href="${path}/user/logout.html">退出</a></li>
                    </ul>
                </li>
            <#else>
           		 <li><a href="${path}/user/login.html">登录</a></li>
                <li><a href="${path}/user/register.html">注册</a></li>
            </#if>
            
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
