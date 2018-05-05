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

function showMyNotice(message) {
    if($("#global-notice-modal").length>0){

    }else{
        var modalHtml='<div class="modal fade" id="global-notice-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" style="position:fixed;top:100px;">'+
            '<div class="modal-dialog modal-sm" role="document">'+
            '<div class="modal-content">'+
            '<div class="modal-header">'+
            '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
        '<h4 class="modal-title" id="myModalLabel">提示</h4>'+
        '</div>'+
        '<div class="modal-body">'+
        '<p class="error-message"></p>'+
        '</div>'+
        '<div class="modal-footer">'+
        '<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>';
        $("body").append(modalHtml);
    }

    $("#global-notice-modal .error-message").html(message);
    $("#global-notice-modal").modal();

}
