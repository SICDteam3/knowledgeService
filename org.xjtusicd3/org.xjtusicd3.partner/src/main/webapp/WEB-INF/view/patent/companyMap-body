
<div class="container-fluid" style="width: 1170px">
    <div class="row">
        <div class="col-lg-12 col-sm-12 col-md-12">
            <h1 class="gallery-title">企业地图</h1>
            <h3 class="gallery-subtitle">对企业地图进行分析：</h3>
        </div>
    </div>
    <div class="row gallery-row">
        <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">输入企业名：</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputEmail3" placeholder="ipc">
            </div>
            <div class="col-sm-4">
                <button type="button" class="btn btn-default">查询</button>
            </div>
        </div>
        </form>
    </div>
    <div class="row gallery-row">
        <div class="col-sm-6">
            <div id="main" style="width: 100%;height: 600px;"></div>
        </div>
        <div class="col-sm-6">
            <div id="main1" style="width: 100%;height: 600px;"></div>
        </div>

    </div>
    <div class="row gallery-row">

        <div class="col-sm-12">
            <div id="main2" style="width: 100%;height: 600px;"></div>
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
    var myChart = echarts.init(document.getElementById('main'));
    var myChart1 = echarts.init(document.getElementById('main1'));
    var myChart2 = echarts.init(document.getElementById('main2'));
    // 指定图表的配置项和数据

    

    var option1 = {
        title : {
            text: '某地区蒸发量和降水量',
            subtext: '纯属虚构'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['蒸发量','降水量']
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
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
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
                name:'降水量',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                markPoint : {
                    data : [
                        {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                        {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
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
    var option = {
        title : {
            text: '世界人口总量',
            subtext: '数据来自网络'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['2011年', '2012年']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'value',
                boundaryGap : [0, 0.01]
            }
        ],
        yAxis : [
            {
                type : 'category',
                data : ['巴西','印尼','美国','印度','中国','世界人口(万)']
            }
        ],
        series : [
            {
                name:'2011年',
                type:'bar',
                data:[18203, 23489, 29034, 104970, 131744, 630230]
            },
            {
                name:'2012年',
                type:'bar',
                data:[19325, 23438, 31000, 121594, 134141, 681807]
            }
        ]
    };

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

    option2 = {
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
            data:['scatter1','scatter2']
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
                splitNumber: 4,
                scale: true
            }
        ],
        yAxis : [
            {
                type : 'value',
                splitNumber: 4,
                scale: true
            }
        ],
        series : [
            {
                name:'scatter1',
                type:'scatter',
                symbolSize: function (value){
                    return Math.round(value[2] / 5);
                },
                data: randomDataArray()
            },
            {
                name:'scatter2',
                type:'scatter',
                symbolSize: function (value){
                    return Math.round(value[2] / 5);
                },
                data: randomDataArray()
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart1.setOption(option1);
    myChart2.setOption(option2);
</script>
