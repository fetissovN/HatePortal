
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
    $('#idDown').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestUserSort(addressValue);
    });
    $('#idUp').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestUserSort(addressValue);
    });
    $('#rateDown').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestUserSort(addressValue);
    });
    $('#rateUp').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestUserSort(addressValue);
    });
    // $('#usersPostsLink').on('click', function(e){
    //     alert('1112');
    //     e.preventDefault();
    //     var addressValue = $(this).attr("href");
    //     ajaxUsersPosts(addressValue);
    // });
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

