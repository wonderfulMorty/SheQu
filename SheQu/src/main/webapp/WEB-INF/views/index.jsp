<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/3
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="${pageContext.request.contextPath}/personInfo">物业管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <span>
                    ${sessionScope.admin.getName()}
                </span>
               <%-- <img src="${pageContext.request.contextPath}/uploads/${sessionScope.user.getPhoto()}"/>--%>
                <img src="http://fp1.fghrsh.net/2020/02/11/9c9aab8ab16d0754e3d6121b661e5016.png"/>
            </a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="${pageContext.request.contextPath}/loginOut">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>账户设置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/personInfo">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>账户信息</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/changepwd">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>用户密码修改</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>小程序管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/notices">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>社区公告管理</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/goods">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>二手商品管理</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/survey">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>问卷管理</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/question">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>题目管理</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/sur_que">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>问卷-题目关联管理</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/choice">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>选项管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>小程序数据查询</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/pay">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>缴费查询</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/choice_user">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>问卷查询</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/goodspay">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>二手商品支付查询</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/repair">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>维修查询</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${pageContext.request.contextPath}/personInfo' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
<script>
    L2Dwidget.init({
        "model": {
            //jsonpath控制显示那个小萝莉模型，下面这个就是我觉得最可爱的小萝莉模型，替换时后面名字也要替换掉
            jsonPath: "https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",
            "scale": 1
        },
        "display": {
            "position": "left", //看板娘的表现位置
            "width": 80,  //小萝莉的宽度
            "height": 160, //小萝莉的高度
            "hOffset": 0,
            "vOffset": -20
        },
        "mobile": {
            "show": true,
            "scale": 0.5
        },
        "react": {
            "opacityDefault": 0.7,
            "opacityOnHover": 0.2
        }
    });
</script>
<div class="footer">
    <div class="copyright">物业管理系统</div>
</div>
</body>
</html>