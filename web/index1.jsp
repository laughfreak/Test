<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<table id="mytab"></table>

<script type="text/html" id="addStudentToolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addStudent">添加学生</button>
    </div>
</script>


<script type="text/html" id="updateStudentBar">
    <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="updateStudent">编辑</a>
    <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delStudent">删除</a>
</script>
</body>
<script src="layui/layui.js"></script>

<script>

    layui.use('table', function () {
        var table = layui.table;
        var $=layui.jquery;

        //第一个实例
        table.render({
            elem: '#mytab'
            ,toolbar:"#addStudentToolBar"
            , height: 540
            , url: '/queryStudent' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type:'checkbox'},
                {field: 'sid', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'sname', title: '学生', width: 380}
                , {field: 'tname', title: '老师', width: 180, sort: true, templet: function (obj) {
                        return obj.teacher.tname;
                    }
                }
                ,{title: '操作', width:380,toolbar:"#updateStudentBar"}
            ]]
        });
        table.on("toolbar()",function (obj){
            //添加事件
            if(obj.event=='addStudent'){
                layer.open({
                    type:2,//弹出层类型
                    title:"添加学生",
                    content:"/add.jsp",//弹出层内容
                    area: ['60%', '40%']
                });
            }
        })
        table.on("tool()",function (obj) {
            var data=obj.data;
            if (obj.event=="delStudent"){
                layer.confirm("是否删除？",function (index) {
                    $.ajax({
                        url:"/delStudent/"+data.sid,
                        success:function (data) {
                            layer.close(index);
                            table.reload('mytab',{
                                url:'/queryStudent'
                            })
                        }
                    })

                },function () {

                    })
            }
            if(obj.event=='updateStudent'){
                layer.open({
                    type:2,//弹出层类型
                    title:"修改用户",
                    content:"/queryBySid/"+data.sid,//弹出层内容
                    area: ['60%', '40%']
                });
            }
        })
    });


</script>

</html>
