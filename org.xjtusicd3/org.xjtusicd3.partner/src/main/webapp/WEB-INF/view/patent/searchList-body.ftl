
<div class="container-fluid" style="width: 1170px">
    <div class="row">
        <div class="col-lg-12 col-sm-12 col-md-12" style="border-bottom: 1px dotted #ccc;">
            <h1 class="gallery-title">专利列表</h1>

            <h3 class="gallery-subtitle">专利分析，报表生成，企业地图，专家地图。</h3>
        </div>
    </div>
    <div class="row gallery-row content content-search clear">
        <div class="col-sm-9 right">           
            <div class="record-item-list">
            	<#list patentPage.results as patent>
                <div class="record-item">
                    <div class="left-record">
                        <div class="record-title">
                            <span class="index">${patent_index+1+(patentPage.pageNo-1)*patentPage.pageSize}.</span>
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
              <span style="display: inline-block;float: left;width: 80px;margin-top: 27px;margin-left: 30px;">总共 ${patentPage.totalPage} 页</span>
			  <ul class="pagination pagination-md">
			  <#list patentPage.pageNo-5 .. patentPage.pageNo+8 as t>
				<#if (t lt patentPage.totalPage+1)&&(t gt 0)>
			    <li <#if t=patentPage.pageNo>class="active"</#if>><a href="searchpage.html?content=${content}&&currentpage=${t}&&searchtype=${searchtype}">${t}</a></li>  
			   	</#if>
			   </#list>
			  </ul>
			</nav>            
        </div>
        <div class="col-sm-3 left" >
        	<div class="row ">
        		<div id="relatedResearchers" class="md">
        			<div class="hd"><span class="title">相关专家</span></div>
        			<ul class="bd clear">
        			<li><a target="_blank" href="http://social.wanfangdata.com.cn/Locate.ashx?ArticleId=tyky200502017&amp;Name=%E6%9D%8E%E4%B9%8B%E4%BF%8A">李之俊</a>
        			</li>
        			</ul>
        		</div>
        	</div>
        	<div class="row ">
        		<div id="relatedResearchers" class="md">
        			<div class="hd"><span class="title">相关企业</span></div>
        			<ul class="bd clear">
        			<li><a target="_blank" href="http://social.wanfangdata.com.cn/Locate.ashx?ArticleId=tyky200502017&amp;Name=%E6%9D%8E%E4%B9%8B%E4%BF%8A">华为无线</a>
        			</li>
        			</ul>
        		</div>
        	</div>
        </div>
    </div>
</div>
