$(document).ready(function () {
    $('#adminMessUpdate').on('click', function(e){
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
    $('#mess').show();
    $('#adminMessUpdate').show();
    $('#messageAjaxId').remove();
});



function ajaxRequestMessUpdShow(urlFrom){

    $.ajax({
        type: 'GET',
        url: urlFrom,
        // data: {'s': term},
        success: function(data){
            $('#updMessPlace').append(data);
            $('#mess').hide();
            $('#adminMessUpdate').hide();


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
                $('#mess').show();
                $('#mess').html(data);
                $('#adminMessUpdate').show();
                $('#messageAjaxId').remove();
            }

        },
        error: function () {
            alert("fail!");
        }

    });
}
