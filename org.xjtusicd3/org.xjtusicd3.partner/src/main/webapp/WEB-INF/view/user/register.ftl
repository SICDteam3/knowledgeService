<#assign path="${rc.contextPath}">
<!DOCTYPE html>
<html lang="en">	
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>西安交通大学社会智能实验室</title>

	    <meta name="robots" content="INDEX,FOLLOW">
	    <meta name="keywords" content="专利分析">
	    <meta name="description" content="西安交通大学社会智能实验室知识服务小组 专利分析">

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${path}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${path}/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${path}/assets/css/form-elements.css">
        <link rel="stylesheet" href="${path}/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${path}/assets/ico/favicon.png">
        <link rel="apple-tou ch-icon-precomposed" sizes="144x144" href="${path}/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${path}/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${path}/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${path}/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><a href="${path}/index.html"><strong>XXZL</strong> 专利分析平台注册</a></h1>
                            <div class="description">
                            	<p>
	                            	西安交通大学  <a href=""><strong> / </strong></a>社会智能与复杂数据处理实验室
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>注册我们的平台</h3>
                            		<p>请输入个人账号信息来注册</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="save.html" method="post" class="login-form" onsubmit="return validate()">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">用户名</label>
			                        	<input type="text" name="username" value="${session_name}" placeholder="用户名..." class="form-username form-control" id="username" onChange="check3('username')">
			                        	 <div id="usernameCheck" style="font-weight:bold;" hidden="true">姓名必须4-8位！</div>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">密码</label>
			                        	<input type="password" name="password" placeholder="密码..." class="form-password form-control" id="password" onChange="check3('password')">
			                        	<div id="passwordCheck" style=" font-weight:bold;" hidden="true">密码必须6-12位！</div>
			                        </div>		                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">邮箱</label>
			                        	<input type="text" name="email" placeholder="邮箱..." class="form-password form-control" id="email" onChange="check3('email')">
			                        	<div id="emailCheck" style=" font-weight:bold;" hidden="true">电子邮件名非法！</div>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">联系方式</label>
			                        	<input type="text" name="phone" placeholder="联系方式..." class="form-password form-control" id="phone" onChange="check3('phone')">
			                        	<div id="phoneCheck" style=" font-weight:bold;" hidden="true">手机号必须11位！</div>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">出生日期</label>
			                        	<input type="date" style="color: #888;height: 50px;background: #f8f8f8;border: 3px solid #ddd;font-family: 'Roboto', sans-serif;font-size: 16px;font-weight: 300;line-height: 50px;" name="birth" placeholder="出生日期..." class="form-password form-control" id="birth" onChange="check3('birth')">
			                        	<div id="birthCheck" style=" font-weight:bold;" hidden="true">必填项！</div>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">兴趣爱好</label>
			                        	<input type="text" name="hobby" placeholder="兴趣爱好..." class="form-password form-control" id="hobby" onChange="check3('hobby')">
			                        	<div id="hobbyCheck" style=" font-weight:bold;" hidden="true">输入字段位5-20位！</div>
			                        </div>
			                        <button type="submit" class="btn">注册</button>
			                    </form>
		                    </div>
		                    
		                     <script>         
					          	function check3(str)
					        	{
					            	var x = document.getElementById(str);
					            	var y = document.getElementById(str+"Check");           
					            	if(str=="username")
					            	{
					                	x = x.value.length;
						                if(x<4) {
						                    y.hidden = false;
						                }
						                else if(x>8){
						                 	y.hidden = false;
						                } else{
						                    y.hidden = true;
						                }
						            }
						            else if(str=="password")
						            {
						                x = x.value.length;
						                if(x<6) {
						                    y.hidden = false;
						                }
						                else if(x>12){
						                 	y.hidden = false;
						                } else{
						                    y.hidden = true;
						                }
						            }
						             else if(str=="email")
						            {
						                x = x.value.indexOf("@"); 
						                if(x == -1)
						                {
						                	y.hidden = false;
						                } 
										else{
						            		y.hidden = true;
						            	}
						            }        
						             else if(str=="phone")
					            	{
					                	x = x.value.length;
						                if(x!=11) {
						                    y.hidden = false;
						                } else{
						                    y.hidden = true;
						                }
					            	}
					            	 else if(str=="birth")
					            	{
					                	if(x.value=="")
                    						y.hidden = false;
                						else
                    						y.hidden = true;
					            	}
					            	 else if(str=="hobby")
					            	{
					                	x = x.value.length;
						                if(x>20) {
						                    y.hidden = false;
						                }else if(x<5){
						                 	y.hidden = false;
						                }  
						                else{
						                    y.hidden = true;
						                }
					            	}   
						            return y.hidden;
						        	}
					        
					        	function validate()
					        	{
					            	var arr=["username", "email","password", "phone","birth","hobby"];
					            	var i = 0;
					            	submitOK = true;
						            while(i <6)
						            {
						                if(!check3(arr[i]))
						                {
						                    alert(arr[i]+" 输入错误!");
						                    submitOK = false;
						                    break;
						                }
						                i++;
						            }
						            if(submitOK)
						            {
						                alert("提交成功！");
						                return true;
						            }
						            else
						            {
						                alert("提交失败");
						                return false;
						            }
						        }
								
						        
					          </script>
		                    
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="${path}/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${path}/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${path}/assets/js/jquery.backstretch.min.js"></script>
        
        <!--[if lt IE 10]>
            <script src="${path}/assets/js/placeholder.js"></script>
        <![endif]-->

    </body>
		<script>
			jQuery(document).ready(function() {
	
			    /*
			        Fullscreen background
			    */
			    $.backstretch("${path}/assets/img/backgrounds/1.jpg");
			    
			    /*
			        Form validation
			    */
			    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
			    	$(this).removeClass('input-error');
			    });
			    
			    $('.login-form').on('submit', function(e) {
			    	
			    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
			    		if( $(this).val() == "" ) {
			    			e.preventDefault();
			    			$(this).addClass('input-error');
			    		}
			    		else {
			    			$(this).removeClass('input-error');
			    		}
			    	});
			    	
			    });
			    
			    
			});
			
		</script>
</html>