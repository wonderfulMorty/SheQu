<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/3
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>线路信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script type="text/html" id="barDemo">
    <a title="修改 "   onclick="updateLine()" href="javascript:;" class="layui-btn layui-btn-sm" >修改</a>
    <a title="删除"  onclick="deleteLine()" href="javascript:;" lay-event="edit" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
</script>
<script type="text/html" id="img">
    <img src="${pageContext.request.contextPath}/img/{{d.img}}" onclick="showBigImage(this)">
</script>
<script type="text/html" id="avatarUrl">
    <img src="${pageContext.request.contextPath}/img/{{d.avatarUrl}}" onclick="showBigImage(this)">
</script>

<body class="layui-anim layui-anim-up">

<div  style="margin-left: 20px; margin-top: 20px">
    <%--   <form id="userSearch" class="layui-input-inline" method="post" action="" style="margin-top: 20px;">
           <div class="layui-row">
               文章标题搜索：
               <div class="layui-inline">
                   <input class="layui-input" name="id" id="demoReload" autocomplete="off">lay
               </div>
           </div>
       </form>
       <div class="layui-input-inline" style="margin-top: 20px">
           <button class="layui-btn" data-type="reload">条件搜索</button>
       </div>--%>
    <div class="demoTable" >
        <button class="layui-btn layui-btn-primary layui-border-red" onclick="addLine()">增加线路</button>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;float:right" href="javascript:location.replace(location.href);" title="刷新">
            <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <table id="lineInfo" lay-filter="lineInfo"></table>
</div>
</body>
<script>
    layui.use(['table','form'], function(){
        var table = layui.table;
        var form = layui.form;
        var tableIns = table.render({
            elem: '#lineInfo'  //绑定table表格
            ,id:'lineInfo'
            ,method:'post'
            ,contentType:"application/json;charset=UTF-8"
            ,url: '${pageContext.request.contextPath}/line/page' //后台springmvc接收路径
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
                ,limit:5
                ,limits:[5,10,20]
            }
            ,request:{
                pageName: 'currentPage'
                ,limitName:'rowsOfPage'
            }
            , parseData: function (res) {
                return {
                    "data": res.data.datas,
                    "count": res.data.pageSize
                };
            }
            ,cols: [
                [
                    {type: 'checkbox'}
                    ,{field:'id',title:'id', sort: true}
                    ,{field:'name', title:'线路名'}
                    ,{field:'color', title:'颜色'}
                    ,{field:'beginTime', title: '起始时间'}
                    ,{field:'endTime', title: '结束时间'}
                    ,{field:'city', title: '城市'}
                    ,{field:'operation',title:'操作',toolbar: '#barDemo'}
                ]
            ]
            ,response: {
                dataName: 'data.datas',
                count: 'data.totalRows'
            }

        });
    });

    //线路增加
    function addLine(){
        layer.open(
            {
                type: 2,
                title: '添加线路',
                skin: 'layui-layer-lan',
                shadeClose: false,
                shade: 0.8,
                area:  ['500px', '500px'],
                resize:true,
                content:'${pageContext.request.contextPath}/line_add',
                end: function(){
                    window.location.reload(); //刷新父页面
                }
            }
        );
    }

    function deleteLine() {
        var id="";
        layui.use('table',function(){
            var table = layui.table
            var checkStatus = table.checkStatus('lineInfo');
            id = checkStatus.data[0].id;
            var idNum = {"id": id };
            $.ajax({
                url:'${pageContext.request.contextPath}/line/delete',
                data:JSON.stringify(idNum),
                type:'POST',
                contentType : "application/json",
                success:function (data) {
                    console.log(data)
                    layer.msg("删除成功！",function(){
                        window.location.reload();
                    });
                },error:function(args){
                    layer.msg("删除失败！",function(){

                    });
                }
            })
        });
    }

    function updateLine() {
        var id="";
        layui.use('table',function(){
            var table = layui.table
            var checkStatus = table.checkStatus('lineInfo');
            id = checkStatus.data[0].id;
        });
        layer.open({
            type: 2,
            title: '修改线路',
            skin: 'layui-layer-molv',
            shadeClose: false,
            shade: 0.8,
            area:  ['500px', '500px'],
            content: 'line_update?id='+id,
            end: function(){
                window.location.reload(); //刷新父页面
            }
        });
    }
    function showBigImage(e) {
        layer.open({
            type: 1,
            shadeClose: true, //点击阴影关闭
            skin: 'layui-layer-rim',
            end: function (index, layero) {
                return false;
            },
            area: ['80%', '80%'],
            content: "<img src=" + $(e).attr('src') + " />"
        });
    }
</script>
</html>
