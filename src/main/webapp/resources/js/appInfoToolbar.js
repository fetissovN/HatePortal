$('body').on('click', '#submitInfo', function(e){
    e.preventDefault();
    ajaxSentInfoForm();

    function ajaxSentInfoForm(){

        $.ajax({
            type: 'POST',
            url: '/infoCh',
            data: $('#infoFormId').serialize(),
            success: function(data){
                if(data!=1 && data!=0){
                    $('.translucent-form-overlay').remove();
                    $('#formB').append(data);
                }else if (data==0){
                    $('.translucent-form-overlay').remove();
                    window.location.href = "/log/";
                }else if (data==1){
                    $('.translucent-form-overlay').remove();
                    alert('saved!');
                }
            }
        });
    }

});
$(document).ready(function () {
    $('#toolBarInfo').on('click', function(){
        var feedExist = $('.translucent-form-overlay-feed');
        var infExist = $('.translucent-form-overlay');
        if(feedExist.length > 0){
            $('.translucent-form-overlay-feed').remove();
            ajaxRequestInf();
        }else if (infExist.length > 0){
            $('.translucent-form-overlay').remove();
        }else {
            ajaxRequestInf();
        }


        var cookie = $.cookie("timestamp");
        var cookie2 = $.cookie("auth");
        // alert(cookie);
        // alert(cookie2);

        // if (cookie==1){
        // ajaxRequestInf();
        // }else {
        //     window.location.href = "/log/";
        // }
    });
});

function ajaxRequestInf(){

    $.ajax({
        type: 'GET',
        url: '/showInfo',
        // data: {'s': term},
        success: function(data){
            $('#formB').append(data);
        }
    });
}
