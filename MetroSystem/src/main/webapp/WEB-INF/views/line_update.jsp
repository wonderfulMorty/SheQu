<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>线路修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/getQueryString.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="layui-unselect lau-sign-body" style="padding-top: 20px" >
<form  class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">所在城市</label>
        <div class="layui-input-block">
            <select name="city" lay-verify="">
                <option value="">请选择一个城市</option>
                <option value="深圳市">深圳</option>
                <option value="上海市">上海</option>
                <option value="杭州市">杭州</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >线路名</label>
        <div class="layui-input-block" id="avatarUrl_div">
            <input type="text" name="name" required  lay-verify="required" placeholder="请输入线路名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">线路颜色</label>
        <div class="layui-input-block" id="content_div">
            <input type="text" name="color" required  lay-verify="required" placeholder="请输入颜色" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">起始时间</label>
        <div class="layui-input-block">
            <input type="text" name="beginTime" required  lay-verify="required" placeholder="请输入起始时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >结束时间</label>
        <div class="layui-input-block" id="img_div">
            <input type="text" name="endTime" required  lay-verify="required" placeholder="请输入结束时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-form-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="submitMessage">提交</button>
        </div>
    </div>
</form>
</body>
<script>
    var id = getQueryString("id")
    //console.log(qs_id)
    var avatarUrl_imgpath,img_imgpath,content_path;
    layui.use(['upload','form'], function(){
        var $ = layui.jquery,upload = layui.upload,form=layui.form;

        form.val("")

        form.on('submit(submitMessage)', function(result) {
            console.log("result.field:"+typeof (result.field))//object
            res = result.field
            data = JSON.stringify(res)//把js对象转换成json字符串,string
            console.log("data:"+typeof (data))
            //var person={"name":"zhangsan","sex":"男","age":"24"}
            //console.log("person:"+typeof (person))
            //sconsole.log(data.field.type())
            $.ajax({
                url : '${pageContext.request.contextPath}/line/add',
                data : JSON.stringify(res),
                type:'POST',
                dataType:'text',
                contentType : 'application/json',
                success:function(data){
                    if(data=="true" || data=="success"){
                        layer.msg("成功！",function(){

                        });
                    }else{
                        layer.msg(data, function(){

                        });
                    }
                },
                error:function(args){
                    layer.msg("失败！",function(){

                    });
                }
            });
        });

    })
</script>
</html>
