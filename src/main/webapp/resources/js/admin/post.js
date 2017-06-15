$(document).ready(function () {
    $('#postIdDown').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestPostSort(addressValue);
    });
    $('#postIdUp').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestPostSort(addressValue);
    });
    $('#postDateDown').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestPostSort(addressValue);
    });
    $('#postDateUp').on('click', function(e){
        e.preventDefault();
        var addressValue = $(this).attr("href");
        ajaxRequestPostSort(addressValue);
    });
});

function ajaxRequestPostSort(urlFrom){

    $.ajax({
        type: 'GET',
        url: urlFrom,
        success: function(data){
            $('.postDefault').remove();
            $('.postAdminAjax').remove();
            $('.postAdminIncome').append(data);
        },
        error: function () {
            alert("fail!");
        }
    });
}

