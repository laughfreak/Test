<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
<div class="layui-container">
    <form class="layui-form" action="/updateStudent" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-block">
                <input type="text" name="sid" value="${student.sid}" readonly class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学生</label>
            <div class="layui-input-block">
                <input type="text" name="sname" required value="${student.sname}" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">老师</label>
            <input  type="hidden" id="tid" value="${student.teacher.tid}"/>
            <div class="layui-input-block">
                <select name="teacher.tid" id="teacherId" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="/layui/layui.js"></script>


<script>

    layui.use(['form','table'],function (){
        var form=layui.form;
        var table=layui.table;
        var $=layui.jquery;
        $.ajax({
            url:"/queryTeacher",
            success:function (data) {
                var stuselect=document.getElementById("teacherId");
                var html="";
                for (var i=0;i<data.length;i++){
                    if ($("#tid").val()==data[i].tid){
                        html+="<option selected value='"+data[i].tid+"'>"+data[i].tname+"</option>";
                    }else{
                        html+="<option value='"+data[i].tid+"'>"+data[i].tname+"</option>";
                    }


                }
                stuselect.innerHTML=html;
                form.render("select");

            }
        })
        form.on("submit",function (){

            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭

            //刷新父页面
            window.parent.location.reload('mytab',{
                url: '/queryStudent'//重新访问controller
            });//刷新父页面


        })

    })




</script>


</html>
