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
