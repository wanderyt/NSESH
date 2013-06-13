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
                i = 0,
                len = photoTypes.length,
                $li,
                $photoDiv,
                $titleDiv,
                $ui = $(".photosUl");
            for(; i < len; i++) {
                $li = $("<li></li>").addClass("photoTypeLi");
                $photoDiv = $("<div></div>").addClass("photoDiv");
                $photoDiv.css("background-image", photoTypes[i].photoURL);
                $titleDiv = $("<div></div>").addClass("photoTitleDiv");
                $titleDiv.text(photoTypes[i].photoType);
                $li.append($photoDiv);
                $li.append($titleDiv);
                $ui.append($li);
            }
        }
    });
});