<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<#assign path="${rc.contextPath}">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css"href="${path}/css/bootstrap.css">
	<link rel="stylesheet" type="text/css"href="${path}/css/main.css">
	
	<script type="text/javascript" src="${path}/js/jquery-1.12.3.min.js"></script>
 	<script type="text/javascript" src="${path}/js/bootstrap.js"></script>
	<script type="text/javascript" src="${path}/js/main.js"></script>

</head>
<body>
	<div class="ylcon">
		<div class="tit">
			<div class = "aut_na">
				<span >评论列表</span>
			</div>
			<div class="btn-group btn-group-xs edit_ri" role="group" aria-label="...">
				<button type="button" class="btn btn-default liuyan" >我要留言</button>
			</div>
		</div>

<#list list as a>
			<div class="story">
				<div class="opbtn"></div>
				<div class="m_top">
					<div class = "aut_na">
						<h4><strong>${a.username}</strong>&nbsp;&nbsp;&nbsp;</h4>
					</div>
					<div class="btn-group btn-group-xs edit_ri" role="group" aria-label="...">
						<button type="button" class="btn btn-default huifu" onclick="$('#replyForm_${a_index}').show();" ><span class="glyphicon glyphicon-new-window" aria-hidden="true"></span>&nbsp;回复</button>
					</div>
				</div>
				<p class="story_time">${a.time?number_to_datetime}</p>
				<p class="story_m">${a.title}</p>
				<p class="story_m">${a.cont}</p>
				<#list a.replylist as reply>
					<br/><p class="story_m">        ${reply.rep_cont}</p>
				</#list>
					<div id="replyForm_${a_index}" style="display:none;">
					<form role="form" id="edit_form22" action="addreply.html" method="get">				
						<input  name="tid" type="hidden" value="${a.tid}"/>
						<textarea id="content" class="form-control" name="rep_cont" value="" rows="3"></textarea>
						<button type="submit" class="btn btn-primary" id="sub_btn">完成</button>				
					</form>
					</div>
			</div>
		</#list>
	</div>


	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form role="form" id="edit_form11" action="${path}/forum/addforumlist.html" method="get">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">留言板</h4>
					</div>
					<div class="modal-body">
							<div class="form-group">
								<label for="name">昵称</label>
								<input id="name" class="form-control" name="username" value="${ViewForumList.username}" >
							</div>
						<div class="form-group">
							<label for="content">标题</label>
							<textarea id="title" class="form-control" name="title" value="${ViewForumList.title}" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label for="content">内容</label>
							<textarea id="content" class="form-control" name="cont" value="${ViewForumList.cont}" rows="3"></textarea>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" id="sub_btn">完成</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<!-- 模态框 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form role="form" id="edit_form22" action="addreply.html" method="get">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">回复板</h4>
					</div>
					<div class="modal-body">
							<div class="form-group">
								<label for="name">昵称</label>
								<input id="name" class="form-control" name="username" value="${ViewForumReply.username}" />
								<input  name="tid" type="hidden" value=""/>
							</div>
							
						<div class="form-group">
							<label for="content">内容</label>
							<textarea id="rep_cont" class="form-control" name="rep_cont" value="${ViewForumReply.rep_cont}" rows="3"></textarea>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" id="sub_btn">完成</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>