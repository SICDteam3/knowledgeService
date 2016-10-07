
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
            <div class="haha-body" ></div>
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
    var myChart2 = echarts.init(document.getElementById('main2'));
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

   //专利可视化——申请人
   option1 = {
    title: {
        x: 'center',
        text: '专利申请人',
        subtext: '数据来源中国知网',
        link: 'http://echarts.baidu.com/doc/example.html'
    },
    tooltip: {
        trigger: 'item'
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    grid: {
        borderWidth: 0,
        y: 80,
        y2: 60
    },
    xAxis: [
        {
            type: 'category',
            show: false,
            data: [${date_inventor}]
        }
    ],
    yAxis: [
        {
            type: 'value',
            show: false
        }
    ],
    series: [
        {
            name: '专权人专利数量',
            type: 'bar',
            itemStyle: {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: '{b}\n{c}'
                    }
                }
            },
            data: [${date_inventor_number}],
            markPoint: {
                tooltip: {
                    trigger: 'item',
                    backgroundColor: 'rgba(0,0,0,0)',
                    formatter: function(params){
                        return '<img src="' 
                                + params.data.symbol.replace('image://', '')
                                + '"/>';
                    }
                },
                data: [
                    {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://../asset/ico/折线图.png'},
                    {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://../asset/ico/柱状图.png'},
                    {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://../asset/ico/散点图.png'},
                    {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://../asset/ico/K线图.png'},
                    {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://../asset/ico/饼状图.png'},
                    {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://../asset/ico/雷达图.png'},
                    {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://../asset/ico/和弦图.png'},
                    {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://../asset/ico/力导向图.png'},
                    {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://../asset/ico/地图.png'},
                    {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://../asset/ico/仪表盘.png'},
                    {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://../asset/ico/漏斗图.png'},
                ]
            }
        }
    ]
};
    
   //专利可视化——专权人
   option2 = {
    title: {
        x: 'center',
        text: '专利专权人',
        subtext: '数据来源中国知网',
        link: 'http://echarts.baidu.com/doc/example.html'
    },
    tooltip: {
        trigger: 'item'
    },
    toolbox: {
        show: true,
        feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    grid: {
        borderWidth: 0,
        y: 80,
        y2: 60
    },
    xAxis: [
        {
            type: 'category',
            show: false,
            data: [${date_holder}]
        }
    ],
    yAxis: [
        {
            type: 'value',
            show: false
        }
    ],
    series: [
        {
            name: '专权人专利数量',
            type: 'bar',
            itemStyle: {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: '{b}\n{c}'
                    }
                }
            },
            data: [${date_holder_number}],
            markPoint: {
                tooltip: {
                    trigger: 'item',
                    backgroundColor: 'rgba(0,0,0,0)',
                    formatter: function(params){
                        return '<img src="' 
                                + params.data.symbol.replace('image://', '')
                                + '"/>';
                    }
                },
                data: [
                    {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://../asset/ico/折线图.png'},
                    {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://../asset/ico/柱状图.png'},
                    {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://../asset/ico/散点图.png'},
                    {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://../asset/ico/K线图.png'},
                    {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://../asset/ico/饼状图.png'},
                    {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://../asset/ico/雷达图.png'},
                    {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://../asset/ico/和弦图.png'},
                    {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://../asset/ico/力导向图.png'},
                    {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://../asset/ico/地图.png'},
                    {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://../asset/ico/仪表盘.png'},
                    {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://../asset/ico/漏斗图.png'},
                ]
            }
        }
    ]
};
    
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
    myChart1.setOption(option1);
    myChart2.setOption(option2);
    myChart3.setOption(option3);
    myChart4.setOption(option4);
</script>
<script>
	var width  = 800;
	var height = 1000;
	//数据转换，布局
	var pack = d3.layout.pack()//打包图的布局
	    			.size([ width, height ])//设定装换的范围，转换后顶点的坐标
	    			.radius(20);//转换后最小的圆的半径
	
	var svg = d3.select(".haha-body").append("svg")
	    .attr("width", width)
	    .attr("height", height)
	    .append("g")
	    .attr("transform", "translate(0,0)");
	
	
	d3.json("${path}/data/city2.json", function(error, root) {
		//读取数据并转换
		var nodes = pack.nodes(root);
		var links = pack.links(nodes);
		
		console.log(nodes);
		console.log(links);
		
		svg.selectAll("circle")
			.data(nodes)
			.enter()
			.append("circle")
			.attr("fill","rgb(31, 119, 180)")//颜色
			.attr("fill-opacity","0.4")//透明度级别
			.attr("cx",function(d){
				return d.x;
			})
			.attr("cy",function(d){
				return d.y;
			})
			.attr("r",function(d){
				return d.r;
			})
			.on("mouseover",function(d,i){//鼠标指针位于元素上方时，改变元素的背景色
				d3.select(this)
					.attr("fill","yellow");
			})
			.on("mouseout",function(d,i){//鼠标指针离开元素上方时，还原元素的背景色
				d3.select(this)
					.attr("fill","rgb(31, 119, 180)");
			});
		
		svg.selectAll("text")
					  .data(nodes)
					  .enter()
					  .append("text")
					  .attr("font-size","10px")
					  .attr("fill","white")
					  .attr("fill-opacity",function(d){
						  if(d.depth == 2)
							  return "0.9";
						  else
							  return "0";
					  })
					  .attr("x",function(d){ return d.x; })
					  .attr("y",function(d){ return d.y; })
					  .attr("dx",-12)
					  .attr("dy",1)
					  .text(function(d){ return d.name; });
		
	});

</script>
<script>
	
</script>
