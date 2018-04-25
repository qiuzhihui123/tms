<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="../../../include/css.jsp"%>
</head>
<body class="hold-transition skin-yellow sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../../include/header.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../../include/sider.jsp">
        <jsp:param name="menu" value="chart"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票统计表
                <small>-焦作市旅游局</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div id="ticket" style="height: 300px;width: 80%"></div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../../include/js.jsp"%>
<script src="/static/plugins/echarts/echarts.min.js"></script>

<script>
    $(function(){
        var ticket = $("#ticket")[0];
        var myEchart = echarts.init(ticket);

      /*  var weatherIcons = {
            'Sunny': './data/asset/img/weather/sunny_128.png',
            'Cloudy': './data/asset/img/weather/cloudy_128.png',
            'Showers': './data/asset/img/weather/showers_128.png'
        };*/

        option = {
            title: {
                text: '旅游年票销售统计',
                subtext: '总数:',
                left: 'center'
            },
            textStyle:{
                fontSize:20
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                // orient: 'vertical',
                // top: 'middle',
                bottom: 10,
                left: 'center',
                data: ['西凉', '益州','兖州','荆州','幽州']
            },
            series : [
                {
                    type: 'pie',
                    radius : '65%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    /*data:[
                        {
                            value:1548,
                            name: '已入库',

                        },
                        {value:510, name: '已下发'},
                        {value:634, name: '已销售'},
                        {value:735, name: '已挂失'},
                        {value:444,name:'已过期'}
                    ],*/
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myEchart.setOption(option);

        $.get("/ticket/repository/chart.json").success(function (data) {
            if(data.status == 'success'){
                var appear = [
                                 {name:'已过期',value:data.data.past_num},
                                {name:'已入库',value:data.data.in_num},
                                {name:'已挂失',value:data.data.lost_num},
                                {name:'已下发',value:data.data.out_num},
                                {name:'已销售',value:data.data.saled_num}
                               ];


                option={
                    title: {
                        text: '旅游年票销售统计',
                        subtext: '总数:'+ data.data.total_num,
                        left: 'left'
                    },
                    series:[{
                        data:appear
                    }]
                }

                myEchart.setOption(option);

            }
        }).error(function () {
            alert("服务器异常");
        });


    })

</script>
</body>
</html>