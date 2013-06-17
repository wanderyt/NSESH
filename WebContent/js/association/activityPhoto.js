/**
 * ActivityPhoto javascript file
 */
var nsesh = nsesh || {};

$(function() {
    $(".photosDisplay").addClass("hidden");
    $(".photosUl").removeClass("hidden");

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
            $(".photoTypeLi").click(function() {
                var selectLi = $(this).find(".photoTitleDiv").text();
                $.ajax({
                    url: 'getPhotoByType.do?actType=' + selectLi,
                    type: "POST",
                    dataType: "JSON",
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        /*var content = [];
                        var photoList = data.photos,
                            j = 0,
                            l = photoList.length;
                        for(; j < l; j++) {
                            var obj = {};
                            obj.href = photoList[j];
                            obj.title = "";
                            content.push(obj);
                        }
                        that.find(".fancyBox").click(function() {
                            $.fancybox.open(content, {
                                padding : 0
                            });
                            return false;
                        });*//*

                        if(!that.find(".hidden")) {
                            var $hiddenDiv = $("<div/>").addClass("hidden")
                            that.find("a").after($hiddenDiv);
                            var photoList = data.photos,
                                j = 1,
                                l = photoList.length;
                            for(; j < l; j++) {
                                $hiddenDiv = __createPhotoElement($hiddenDiv, photoList[j]);
                            }
                        }
                        that.find(".fancyBox").attr('rel', 'gallery');
                        that.find(".fancyBox").fancybox({
                            padding : 0,
                            maxWidth : 300,
                            maxHeight : 300
                        });*/
                        $(".photosDisplay").empty();

                        $(".photosUl").addClass("hidden");
                        var photosList = data,
                            $photoul = $(".photosDisplay"),
                            $photoli,
                            $photoImg,
                            j,
                            l = photosList.length;
                        for(j = 0; j < l; j++) {
                            $photoli = $("<li/>").addClass("photoLi");
                            $photoImg = $("<img/>");
                            $photoImg.attr("src", photosList[j]);
                            $photoli.append($photoImg);
                            $photoul.append($photoli);
                        }
                        $(".photosDisplay").removeClass("hidden");

                        $("img").click(function() {
                            $(this).fancybox({
                                maxHeight: 300,
                                maxWidth: 400,
                                helpers: {
                                    title : {
                                        type : 'float'
                                    }
                                }
                            });
                        });
                    }
                });
            });
        }
    });

    var __createPhotoElement = function($container, url) {
        var $photoDiv,
            $photoImg;
        $photoDiv = $("<a/>").addClass("photoDiv").addClass("fancyBox");
        $photoImg = $("<img/>");
        $photoImg.attr("src", url);
        $photoDiv.append($photoImg);
        $container.append($photoDiv);
        return $container;
    };
});