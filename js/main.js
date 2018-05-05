//single-select
$(".single-labels").on("click", "li", function () {
    $(this).addClass("act").siblings().removeClass("act");
});

//multi-select

//need-nice-select
$("#need-nice-select li").click(function (e) {
    var val = $(this).text(),
        id = $(this).attr("data-id"),
        addable = true;
    var labelList = $("#need-subject-select").find("li");
    //检查是否已有重复标签
    for (var i = 0; i < labelList.length; i++) {
        if (labelList.eq(i).attr("data-id") == id) {
            addable = false;
        }
    }
    if (addable) {
        var labelHtml = '<li class="my-label" data-id="' + id + '">' + val + '</li>';
        $("#need-subject-select").append(labelHtml);
    }

    //    var newId = $("#need-subject-select").find("li").last().attr("data-id");
    //    console.log("add data-id" + newId);
    e.stopPropagation();
});

//supply-nice-select
$("#supply-nice-select li").click(function (e) {
    var val = $(this).text(),
        id = $(this).attr("data-id"),
        addable = true;
    var labelList = $("#supply-subject-select").find("li");
    //检查是否已有重复标签
    for (var i = 0; i < labelList.length; i++) {
        if (labelList.eq(i).attr("data-id") == id) {
            addable = false;
        }
    }
    if (addable) {
        var labelHtml = '<li class="my-label" data-id="' + id + '">' + val + '</li>';
        $("#supply-subject-select").append(labelHtml);
    }

    e.stopPropagation();
});

//delete multi-select
$(".multi-labels").on("click", "li", function () {
    $(this).remove();
});


//nice-select
$('[name="nice-select"]').click(function (e) {
    $('[name="nice-select"]').find('ul').hide();
    $(this).find('ul').fadeIn();
    e.stopPropagation();
});
$('[name="nice-select"] li').hover(function (e) {
    $(this).toggleClass('on');
    e.stopPropagation();
});
$('[name="nice-select"] li').click(function (e) {
    var val = $(this).text();
    $(this).parents('[name="nice-select"]').find('input').val(val);
    $('[name="nice-select"] ul').fadeOut();
    e.stopPropagation();
});
$(document).click(function () {
    $('[name="nice-select"] ul').fadeOut();
});
