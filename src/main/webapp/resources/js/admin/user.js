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

