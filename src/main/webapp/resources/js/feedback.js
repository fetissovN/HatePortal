$(document).ready(function () {
    $('#feedback').on('click', function(){
        var feedExist = $('.translucent-form-overlay-feed');
        var infExist = $('.translucent-form-overlay');
        if(feedExist.length > 0){
            $('.translucent-form-overlay-feed').remove();
        }else if (infExist.length > 0){
            $('.translucent-form-overlay').remove();
            ajaxRequestFeed();
        }else {
            ajaxRequestFeed();
        }
    });
});

$('#submitFeed').on('click', function(e){
    e.preventDefault();
    ajaxRequestFeedSend();
});

function ajaxRequestFeed(){

    $.ajax({
        type: 'GET',
        url: '/showFeedback',
        // data: {'s': term},
        success: function(data){
            $('#formFeed').append(data);
        }
    });
}

function ajaxRequestFeedSend(){

    $.ajax({
        type: 'POST',
        url: '/showFeedback',
        data: $('#barFeedbackId').serialize(),
        success: function(data){
            if (data==1){
                $('.translucent-form-overlay-feed').remove();
            }
            alert(data);
        },
        error: function () {
            alert("asdasdasdasd");
        }

    });
}