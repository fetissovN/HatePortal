$(document).on('click','body #postIdDown',function(e){
    e.preventDefault();
    var addressValue = $(this).attr("href");
    ajaxRequestPostSort(addressValue);
});

$(document).on('click','body #postIdUp',function(e){
    e.preventDefault();
    var addressValue = $(this).attr("href");
    ajaxRequestPostSort(addressValue);
});

$(document).on('click','body #postDateDown',function(e){
    e.preventDefault();
    var addressValue = $(this).attr("href");
    ajaxRequestPostSort(addressValue);
});

$(document).on('click','body #postDateUp',function(e){
    e.preventDefault();
    var addressValue = $(this).attr("href");
    ajaxRequestPostSort(addressValue);
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

