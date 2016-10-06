
<div class="container-fluid" style="width: 1170px">
    <div class="row">
        <div class="col-lg-12 col-sm-12 col-md-12" style="border-bottom: 1px dotted #ccc;">
            <h1 class="gallery-title">专利列表</h1>

            <h3 class="gallery-subtitle">专利分析，报表生成，企业地图，专家地图。</h3>
        </div>
    </div>
    <div class="row gallery-row content content-search clear">
        <div class="col-sm-12 right">           
            <div class="record-item-list">
            	<#list listPatent as patent>
                <div class="record-item">
                    <div class="left-record">
                        <div class="record-title">
                            <span class="index">${patent_index}.</span>
                            <a class="fulltext" href="" target="_blank">全文</a>
                            <a class="title" href="" target="_blank">${patent.name}</a>
                        </div>
                        <div class="record-subtitle">
                            [${patent.type}]
                            ${patent.number}&nbsp;&nbsp;${patent.patent_inventor}
                            ${patent.date_of_application}
                        </div>
                        <div class="record-desc">
                        	${patent.patent_abstract}
                        </div>
                    </div>
                </div>
                </#list>
            </div>          
            <nav>
              <span style="display: inline-block;float: left;width: 80px;margin-top: 27px;margin-left: 30px;">共有16页</span>
			  <ul class="pagination pagination-md">
			    <li><a href="#">&laquo;</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li class="active"><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li ><a href="#">&raquo;</a></li>
			  </ul>
			</nav>            
        </div>
    </div>
</div>
