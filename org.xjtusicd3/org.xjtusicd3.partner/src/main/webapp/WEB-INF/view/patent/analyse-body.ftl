
<div class="container-fluid" style="width: 1170px">
    <div class="row">
        <div class="col-lg-12 col-sm-12 col-md-12">
            <h1 class="gallery-title">专利分析</h1>
            <h3 class="gallery-subtitle">专利分析，报表生成，企业地图，专家地图。</h3>
        </div>
    </div>
    <#include "patent/IPClist.ftl">
    <div class="row gallery-row">
        <div class="col-sm-6">
            <div id="main1" style="width: 100%;height: 600px;"></div>
        </div>
        <div class="col-sm-6">
            <div id="main2" style="width: 100%;height: 600px;"></div>
        </div>

    </div>
      <div class="row gallery-row">

        <div class="col-sm-12">
            <div id="main3" style="width: 100%;height: 600px;"></div>
        </div>
    </div>
    <div class="row gallery-row">

        <div class="col-sm-12">
            <div id="main4" style="width: 100%;height: 600px;"></div>
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
    var myChart3 = echarts.init(document.getElementById('main3'));
    var myChart4 = echarts.init(document.getElementById('main4'));
    // 指定图表的配置项和数据
	function random(){
    var r = Math.round(Math.random() * 100);
    return (r * (r % 2 == 0 ? 1 : -1));
}

function randomDataArray() {
    var d = [];
    var len = 100;
    while (len--) {
        d.push([
            random(),
            random(),
            Math.abs(random()),
        ]);
    }
    return d;
}

  
    
option3 = {
    title : {
        text: '专利申请日期/发布日期',
        subtext: '数据来源中国知网'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['申请数量','发布数量']
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
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'申请数量',
            type:'bar',
            data:[${date_application_number}],
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
        },
        {
            name:'发布数量',
            type:'bar',
            data:[${date_announcement_number}],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
};



option4 = {
    tooltip : {
        trigger: 'axis',
        showDelay : 0,
        axisPointer:{
            show: true,
            type : 'cross',
            lineStyle: {
                type : 'dashed',
                width : 1
            }
        }
    },
    legend: {
        data:['专权人']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataZoom : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'value',
            splitNumber: 33,
            scale: true
        }
    ],
    yAxis : [
        {
            type : 'value',
            splitNumber: 30,
            scale: true
        }
    ],
    series : [
        {
            name:'专权人',
            type:'scatter',
            symbolSize: function (value){
                return Math.round(value[2] / 5);
            },
            data: [[200,201,20,'zhao']]
        },
       
    ]
};
       

    // 使用刚指定的配置项和数据显示图表。
    myChart3.setOption(option3);
    myChart4.setOption(option4);
</script>

<script>
	
</script>
