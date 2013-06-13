/**
 * ActivityPhoto javascript file
 */
var nsesh = nsesh || {};

$(function() {
    $(".activityPhotoDetails").mCustomScrollbar({
        verticalScroll: true
    });

    $.ajax({
        url: 'getPhotoType.do',
        type: "POST",
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var photoTypes = data,
                $li,
                $photoDiv,
                $titleDiv,
                $ui = $(".photosUl");
            for(props in photoTypes) {
                if(photoTypes.hasOwnProperty(props)) {
                    $li = $("<li></li>").addClass("photoTypeLi");
                    $photoDiv = $("<img/>").addClass("photoDiv");
                    $photoDiv.attr("src", "file:///" + photoTypes[props]);
                    $titleDiv = $("<div></div>").addClass("photoTitleDiv");
                    $titleDiv.text(props);
                    $li.append($photoDiv);
                    $li.append($titleDiv);
                    $ui.append($li);
                }
            }
        }
    });
});