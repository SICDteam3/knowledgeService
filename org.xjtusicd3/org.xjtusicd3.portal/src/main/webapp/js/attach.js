 $(document).ready(function () {  
    $("#uploadImage").click(function(){ 
    	showImage();
    });
});  
 var isload = false;

var flag = true;
function ajaxFileUpload(){
		//starting setting some animation when the ajax starts and completes
	$("#upload").ajaxStart(function(){
		
	}).ajaxComplete(function(){
		
	});
	var isRight = validateImage();
	if(isRight){
	$.ajaxFileUpload({
		url:'../attach/newAttachment.html', 
		//secureuri:false,
		fileElementId:'attach',
		dataType: 'text',
		success:function(data, status){            //服务器响应成功时的处理函数  
            data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀  
            data = data.replace(/<PRE.*?>/g, '');  
            data = data.replace("<PRE>", '');  
            data = data.replace("</PRE>", '');  
            data = data.replace("<pre>", '');  
            data = data.replace("</pre>", '');     //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]  
            if(data.substring(0, 1) == 0){         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
            	//document.getElementById("div4").style.display="block";
                $("img[id='uploadImage']").attr("src", data.substring(2));
                $("#uploadImage").show();
                $("#noimage").hide();
                $('#result').html('');
                isload = true;
                
            }else if(data.substring(0, 1) == 2){
            	$('#result').html('图片大小不能超过512kb!');
            }else if(data.substring(0, 1) == 1){  
                $('#result').html('文件为空,上传失败');  
            }  
        },  
        error:function(data, status, e){ //服务器响应失败时的处理函数  
            $('#result').html('图片上传失败，请重试！！');  
        }  
	});
	}
}  

function showImage()
{
	var path = $("img[id='uploadImage']")[0].src;
	if(path==null || path==''){
		alert("file is empty");
		return;
	}else{
		imgShow(path);
	}
}

function imgShow(path){
    $("#bigimg").attr("src", path);//设置#bigimg元素的src属性
 
        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
    $("<img/>").attr("src", path).load(function(){
        var windowW = $(window).width();//获取当前窗口宽度
        var windowH = $(window).height();//获取当前窗口高度
        var realWidth = this.width;//获取图片真实宽度
        var realHeight = this.height;//获取图片真实高度
        var imgWidth, imgHeight;
        var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
         
        if(realHeight>windowH*scale) {//判断图片高度
            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
            if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                imgWidth = windowW*scale;//再对宽度进行缩放
            }
        } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                        imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
        } else {//如果图片真实高度和宽度都符合要求，高宽不变
            imgWidth = realWidth;
            imgHeight = realHeight;
        }
                $("#bigimg").css("width",imgWidth);//以最终的宽度对图片缩放
         
        var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
        var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
        $("#innerdiv").css({"top":h, "left":w});//设置#innerdiv的top和left属性
        $("#outerdiv").fadeIn("fast");//淡入显示#outerdiv及.pimg
    });
     
    $(outerdiv).click(function(){//再次点击淡出消失弹出层
        $(this).fadeOut("fast");
    });
}

var imgSize = 1024 * 512;
function validateImage() {
    var file = document.getElementById("attach");
    var val = file.value;
    fileName = val;
    //校验图片格式
    if(/^.*?\.(png|jpg|jpeg)$/.test(val.toLowerCase())){
    } else {
        alert("只能上传jpg、jpeg、png格式的图片！");
        flag = false;
        return false;
    }   
    flag = true;
    return true;
}

function savepw(){
	var username = $("#username").val();
	var url = "../user/modify.html";
	var oriword = $("#oriword").val();
	var newword = $("#newword").val();
	if(checkpw(oriword,newword)){
	var oridig = digest(username + oriword);
	var newdig = digest(username + newword);
	var userInfo = "oriword=" + oridig+"&newword=" + newdig;
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			data : userInfo,
			success : function(data) {
				if(data == 1){
					$("#modifypd").hide();
					$("#tomodifypd").show();
					$("#oriword").val("");
					$("#newword").val("");
					alert("密码修改成功");
					window.location.href="../user/login.html";
				} else if (data == 0){
					alert("原始密码不正确");
				}else{
					alert("密码修改不成功");
				}
			}
		});
	}
}
function digest(data){
	return $.md5(data);
}
function checkpw(oriword,newword){
	 if(!/[a-zA-Z0-9]{6,16}/.test(newword)){
		 alert("请输入密码长度6到16位，只包含数字和字母");
		 return false;
	 }else if(oriword == newword){
		 alert("两次密码不能一致！");
		 return false;
	 }else if(newword.length < 6){
		 alert("密码长度不能小于6");
		 return false;
	 }else if(newword.length >16){
		 alert("密码长度不能大于16");
		 return false;
	 }
	 return true;
}