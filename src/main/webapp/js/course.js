define(function(require,exports,module) {
    require("jquery");
    function init() {
        $.ajax({
            type: "GET",
            url: "/getAllCourses",
            success: function (msg) {
                $("#course_body").empty();
                if (msg) {
                    $.each(msg, function (key, value) {//key是下标，value是对象
                        var tmp = "<tr><td>" + value.stuname + "</td><td>" + value.classname + "</td><td>" + value.subject + "</td><td>" + value.score+ "</td></tr>";
                        $("#course_body").append(tmp);
                    })
                }
            }
        })
    }
    init();
    $("#searchButton").click(function(){
        var searchInput = $("#searchInput").val();
        var method = $("#selectMethod").val();
        $.ajax({
            type: "GET",
            url: "/getLikeSearchResults/"+searchInput+"/"+method,
            success: function(msg){
                $("#course_body").empty();
                if (msg) {
                    $.each(msg, function (key, value) {//key是下标，value是对象
                        var tmp = "<tr><td>" + value.stuname + "</td><td>" + value.classname + "</td><td>" + value.subject + "</td><td>" + value.score+ "</td></tr>";
                        $("#course_body").append(tmp);
                    })
                }
            }
        })
    })


})