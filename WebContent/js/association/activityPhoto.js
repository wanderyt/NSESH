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
                $titleDiv,
                $ui = $(".photosUl");
            for(props in photoTypes) {
                if(photoTypes.hasOwnProperty(props)) {
                    $li = $("<li></li>").addClass("photoTypeLi");
                    $li = __createPhotoElement($li, photoTypes[props]);
                    $titleDiv = $("<div></div>").addClass("photoTitleDiv");
                    $titleDiv.text(props);
                    $li.append($titleDiv);
                    $ui.append($li);
                }
            }

            //add click event on lis of photo types
            $(".photoTypeLi").on("click", function() {
                var selectLi = $(this).find(".photoTitleDiv").text();
                $.ajax({
                    url: 'getPhotoByType.do?actType=' + selectLi,
                    type: "POST",
                    dataType: "JSON",
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        $(".photosDisplay").empty();

                        $(".photosUl").addClass("hidden");
                        var photosList = data.photos,
                            $photoul = $(".photosDisplay"),
                            $photoli,
                            $photoa,
                            $photoImg,
                            j,
                            l = photosList.length;
                        for(j = 0; j < l; j++) {
                            $photoli = $("<li/>").addClass("photoLi");
                            $photoa = $("<a/>").addClass("fancyBox").attr("href", photosList[j]);
                            $photoImg = $("<img/>");
                            $photoImg.attr("src", photosList[j]);
                            $photoa.append($photoImg);
                            $photoli.append($photoa);
                            $photoul.append($photoli);
                        }
                        $(".photosDisplay").removeClass("hidden");
                        $(".clickBack").removeClass("hidden");

                        $(".fancyBox").fancybox({
                            helpers: {
                                title : {
                                    type : 'float'
                                }
                            }
                        });
                        $(".clickBack").click(function() {
                            $(".photosDisplay").addClass("hidden");
                            $(".clickBack").addClass("hidden");
                            $(".photosUl").removeClass("hidden");
                        });
                    }
                });
            });
        }
    });

    var __createPhotoElement = function($container, url) {
        var $photoDiv,
            $photoImg;
        $photoDiv = $("<a/>").addClass("photoDiv");
        $photoImg = $("<img/>");
        $photoImg.attr("src", url);
        $photoDiv.append($photoImg);
        $container.append($photoDiv);
        return $container;
    };
});