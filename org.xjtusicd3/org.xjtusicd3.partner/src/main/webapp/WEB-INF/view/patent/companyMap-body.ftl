
<div class="container-fluid" style="width: 1170px">
    <div class="row">
        <div class="col-lg-12 col-sm-12 col-md-12">
            <h1 class="gallery-title">企业地图</h1>
            <h3 class="gallery-subtitle">对企业地图进行分析：</h3>
        </div>
    </div>
    <div class="row gallery-row">
        <form class="form-horizontal" role="form" action="companyVisiual.html" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">输入企业名：</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="patent_holder" placeholder="企业名称">
            </div>
            <div class="col-sm-4">
                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </div>
        </form>
    </div>
    <div class="row gallery-row">
        <div class="col-sm-12">
            <div id="main1" style="width: 100%;height: 600px;"></div>
        </div>


    </div>
    <div class="row gallery-row">


        <div class="col-sm-12">
            <button type="button" class="btn btn-default btn-lg btn-block">导出生成报表</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('main1'));
   
    // 指定图表的配置项和数据

    

option1 = {
    title : {
        text: '企业专利数据趋势图',
        subtext: '数据来源中国知网'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['企业数量']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : [${date_year}]
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'数量',
            type:'bar',
            data:[${date_year_number}],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }
        
    ]
};
    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
    
</script>
