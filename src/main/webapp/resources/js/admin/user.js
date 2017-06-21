
$(document).on('click','body .usersPostsLink',function(e){
    e.preventDefault();
    var addressValue = $(this).attr("href");

        $.ajax({
            type: 'GET',
            url: addressValue,
            success: function(data){
                $('.postDefault').remove();
                $('.postAdminAjax').remove();
                $('.postAdminIncome').append(data);
            },
            error: function () {
                alert("fail!");
            }
        });
});

$(document).ready(function () {
    $('.userLinkMethod').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestUserSort(addressValue);
    });
});

function ajaxRequestUserSort(urlFrom){

    $.ajax({
        type: 'GET',
        url: urlFrom,
        success: function(data){
            $('.userDefault').remove();
            $('.userAdminAjax').remove();
            $('.userAdminIncome').append(data);
        },
        error: function () {
            alert("fail!");
        }
    });
}

