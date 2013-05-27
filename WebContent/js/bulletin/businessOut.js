/**
 * BusinessOut javascript file
 */
var nsesh = nsesh || {};

$(function() {
    //achieve data
    $.ajax({
        url: 'BusinessOut.do',
        type: "POST",
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $('.businessOutDetails').text(data.title);
        }
    });
    $(".businessOutDetails").mCustomScrollbar({
        verticalScroll: true
    });
});