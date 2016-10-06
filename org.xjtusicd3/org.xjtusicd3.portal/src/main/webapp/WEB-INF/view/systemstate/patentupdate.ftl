<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<#assign path="${rc.contextPath}">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <meta name="description" content="bootstrap admin template">
  <meta name="author" content="">
   <script src="${path}/js/echarts-all.js"></script>
   <script src="${path}/js/jquery-1.7.2.min.js"></script>
  <title>在线人数</title>

  <#include "css.ftl">
</head>
<body class="dashboard" style="font-family: 'Arial','Hiragino Sans GB', \5fae\8f6f\96c5\9ed1, 'Helvetica', 'sans-serif';">
  <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
     <script src="echarts.min.js"></script>
  <#include "topbar.ftl">
  <#include "menubar.ftl">
  <!-- Page -->
  <div class="page animsition">
	<div class="page-header">
      <h1 class="page-title">专利更新状态</h1>    
    </div>
    <div class="page-content">
      <!-- pannel start-->
      <div class="panel">
        <div class="panel-body container-fluid">
          <div id="select" class="form-group">
                    <div class="col-sm-3" style="width:100%;">
                      <label class=" control-label"  style="font-size:16px">选择需要查看的时间段</label>
                    
                    
                    <ul id="test">
                       <li><a href="patentUpdateState.html?time=1">一周</a></li>
                       <li><a href="patentUpdateState.html?time=2">一月</a></li>
                        <li><a href="patentUpdateState.html?time=3">六个月</a></li>
                    </ul>

                     
                      </div>
                     
                    </div>
         
         
        </div>  
        <!-- pannel end-->                  
      </div>
      
      
      <!-- pannel start--> 
     <div class="panel">
 		<div class="panel-body"> 		
 		        <div id = "main" style="width:600px;height:400px">
 		        </div>             
      	</div>   
	</div>
      <!-- pannel end-->
      
    </div>
  </div>
  <!-- End Page -->


  <#include "footer.ftl">
  <!-- Core  -->
  <#include "scriptimport.ftl">
  <script>
   // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
   
    // 指定图表的配置项和数据
  
option = {
    title: {
        x: 'center',
        text: 'ECharts例子个数统计',
        subtext: 'Rainbow bar example',
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
            data: [${time1}]
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
            name: 'ECharts例子个数统计',
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
            data: [${pub}],
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
        
      // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);   
    
    
    
    
  </script>
</body>

</html>