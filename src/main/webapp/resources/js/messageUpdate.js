$(document).ready(function () {
    $('.updMess').on('click', function(e){
        var addressValue = $(this).attr("href");
        e.preventDefault();
        ajaxRequestMessUpdShow(addressValue);
    });
});

$('body').on('click', '#messSubmitUpdateFormId', function(e){
    e.preventDefault();
    ajaxRequestUpdMess();
});
$('body').on('click', '#closeMessFormUpdate', function(){
    $('.mess').show();
    $('.updMess').show();
    $('#messageAjaxId').remove();
});



function ajaxRequestMessUpdShow(urlFrom){

    $.ajax({
        type: 'GET',
        url: urlFrom,
        // data: {'s': term},
        success: function(data){
            var id = $(data).find( ".supportId").html();
            alert(id);
            $('#updMessPlace'+id).append(data);
            $('#mess'+id).hide();
            $('#adminMessUpdate'+id).hide();


            // var json = $.parseJSON(data)
            // $('#mess'+json.id).hide();
            // $('#updMessPlace').append('<input type="text" value="test">');
            // var idMess = $( '#formPostAjax' ).attr( 'id' );
            // $('.article-row').hide();

        },
        error: function () {
            alert("fail!");
        }
    });
}

function ajaxRequestUpdMess(){
    var addressValue = $( '#messageAjaxId' ).attr( 'action' );
    $.ajax({
        type: 'POST',
        url: addressValue,
        data: $('#messageAjaxId').serialize(),
        success: function(data){


            if (data.length > 1){
                var json = $.parseJSON(data);

                $('.mess').show();
                $('#mess'+json.id).html(json.message);
                $('#adminMessUpdate'+json.id).show();
                $('#messageAjaxId').remove();
            }

        },
        error: function () {
            alert("fail!");
        }

    });
}
