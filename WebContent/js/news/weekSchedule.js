/**
 * WeekSchedule javascript file
 */
var nsesh = nsesh || {};

$(function() {
    var colorList = ['#6eb4cd', '#abdebe', '#ebce7b', '#76bab2', '#e8baa5', '#deddda', '#acacac', '#938bc0', '#b7ad80', '#c2c979', '#c2a7d6', '#80b1bb', '#d4c79e'];

    $(".weekScheduleDetails").mCustomScrollbar({
        verticalScroll: true
    });

    $.ajax({
        url: "getWeekSchedule.do",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var weekScheduleList = data.schedule;
            console.log(weekScheduleList);
            __createTableBody(weekScheduleList);
        }
    });

    var __createTableBody = function(data) {
        var $tBody = $(".scheduleBody"),
            i = 0,
            l = data.length,
            $tr,
            $td;
        for(; i < l; i++) {
            $tr = $("<tr/>").addClass("row");
            $td = $("<td/>").addClass("tName");
            $td.attr("align", "center");
            $td.text(data[i].name);
            $tr.append($td);
            $tr = __createRowBody(data[i].ss, $tr);
            $tBody.append($tr);
        }
    };

    var __createRowBody = function(data, $tr) {
        var i = 0,
            l = data.length,
            $td,
            colorFlag = 0,
            totalFlag = 1;
        for(; i < l; i++) {//规则 -- 连续两格在第一格中处理格式
            if(i % 2 === 0){
                if(data[i] === "") {
                    if(data[i + 1] === "") {
                        $td = $("<td/>").addClass("content").attr("colspan", 2);
                        $td.css("width", "12%");
                        $tr.append($td);
                        i++;
                    } else {
                        $td = $("<td/>").addClass("content");
                        $td.css("width", "6%");
                        $tr.append($td);
                    }
                } else {
                    if(data[i + 1] !== data[i]) {
                        $td = $("<td/>").addClass("content").addClass("hasSchedule").attr("colspan", totalFlag);
                        $td.css("width", totalFlag * 6 + "%");
                        $td.attr("align", "center");
                        $td.text(data[i]);
                        $td.css("background", colorList[colorFlag++]);
                        $tr.append($td);
                        totalFlag = 1;
                    } else if(data[i + 1] === data[i]) {
                        totalFlag++;
                    }
                }
            } else if(i % 2 === 1){
                if(data[i] === "") {
                    $td = $("<td/>").addClass("content");
                    $td.css("width", "6%");
                    $tr.append($td);
                } else {
                    if(data[i + 1] !== data[i]) {
                        $td = $("<td/>").addClass("content").addClass("hasSchedule").attr("colspan", totalFlag);
                        $td.attr("align", "center");
                        $td.css("width", totalFlag * 6 + "%");
                        $td.text(data[i]);
                        $td.css("background", colorList[colorFlag++]);
                        $tr.append($td);
                        totalFlag = 1;
                    } else if(data[i + 1] === data[i]) {
                        totalFlag++;
                    }
                }
            }
        }
        return $tr;
    };
});