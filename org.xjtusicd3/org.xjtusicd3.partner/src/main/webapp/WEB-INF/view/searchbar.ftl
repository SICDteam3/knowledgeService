<div class="container-fluid" style="width: 1170px;">
    <div class="row">
    <form action="${path}/search.html" method="post">
    	<div class="col-lg-2">
            <select class="form-control" name="searchType">
				  <option value="1">专利名搜索</option>
				  <option value="2">专利号搜索</option>
				  <option value="3">专家名称搜索</option>	
				  <option value="4">企业名称搜索</option>					 
			</select>
        </div>
        <div class="col-lg-8">                          
            <input type="text" name="context" class="form-control">           
        </div>
        <div class="col-lg-2">
            <button type="submit" class="btn btn-default">搜索</button>
        </div>
      </form>
    </div>
</div>