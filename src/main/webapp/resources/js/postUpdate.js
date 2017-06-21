$(document).ready(function () {
    $('#adminUpd').on('click', function(e){
        var addressValue = $(this).attr("href");
        e.preventDefault();
        ajaxRequestPostUpdShow(addressValue);
    });
});

$('body').on('click', '#submitFormUpdate', function(e){
    e.preventDefault();
    ajaxRequestUpdPost();
});
$('body').on('click', '#closePostFormUpdate', function(){
    $('.article-row').show();
    $('#ajaxPostFormSample').remove();
});

function ajaxRequestPostUpdShow(urlFrom){

    $.ajax({
        type: 'GET',
        url: urlFrom,
        success: function(data){
            $('.article-row').hide();
            $('#updatePost').append(data);
            // $("#updatePost").focus();
        },
        error: function () {
            alert("fail!");
        }
    });
}

function ajaxRequestUpdPost(){
    var addressValue = $( '#formPostAjax' ).attr( 'action' );
    $.ajax({
        type: 'POST',
        url: addressValue,
        data: $('#formPostAjax').serialize(),
        success: function(data){
            if (data.length>10){
                $('#ajaxPostFormSample').remove();
                $('#updatePost').append(data);
            }else {
                window.location.href = "/post/post/" + data;
            }
        },
        error: function () {
            alert("fail!");
        }
    });
}
