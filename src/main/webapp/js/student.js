
define(function(require,exports,module){
    require("jquery");
    $.ajax({//没有放在函数里面，页面加载时就执行，不用点击按钮时才执行。此select下拉框不能放在函数里面写，不然选中之后也不显示
        type:"GET",
        url:"/getAllClasses",
        success:function(msg){
            $.each(msg,function(key,value){//key是下标，value是对象
                var tmp = "<option value='"+value.id+"'>"+value.name+"</option>";
                $("#updateSelect").append(tmp);
            })
        }
    })


    function init() {
        $.ajax({
            type: "GET",
            url: "/getAllStudents",
            success: function(msg){
                $("#student_body").empty();
                if(msg){
                    $.each(msg,function(key,value){//key是下标，value是对象
                        var tmp = "<tr><td>"+value.id+"</td><td>"+value.banji+"</td><td>"+value.name+"</td><td>"+value.age+"</td><td>"+value.sex+"</td><td>"+value.address
                            +"</td><td><button id='update' data-id='"+value.id+"'>修改</button><button id='delete' data-id='"+value.id+"'>删除</button></td></tr>"
                        $("#student_body").append(tmp);
                    })
                }
            }
        })
    }
    init();

    $("#student_body").on("click","#update",function () {
        var stu = {};
        stu.id = $(this).data("id");
        stu.cid= $("#updateSelect").val();
        stu.name = $("#updateInputName").val();
        stu.age = $("#updateInputAge").val();
        stu.sex = $("#updateInputSex").val();
        stu.address = $("#updateInputAddress").val();
        $.ajax({
            type: "POST",
            url: "/updateStudent",
            data: JSON.stringify(stu),
            contentType:"application/json",
            success: function(msg){
                init();
                $("#updateResult").val("修改成功！");
            }
        })
    })

    $("#student_body").on("click","#delete",function () {
        var id = $(this).data("id")
        $.ajax({
            type: "POST",
            url: "/deleteStudent/"+id,
            success: function(msg){
                init();
                $("#updateResult").val("删除成功！");
            }
        })
    })

    $("#insertButton").click(function(){
        var stu = {};
        stu.cid= $("#updateSelect").val();
        stu.name = $("#updateInputName").val();
        stu.age = $("#updateInputAge").val();
        stu.sex = $("#updateInputSex").val();
        stu.address = $("#updateInputAddress").val();
        $.ajax({
            type: "POST",
            url: "/insertStudent",
            data: JSON.stringify(stu),
            contentType:"application/json",
            success: function(msg){
                init();
                $("#updateResult").val("添加成功！");
            }
        })
    })
})
