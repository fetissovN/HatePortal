$('body').on('click', '#submitInfo', function(e){
    e.preventDefault();
    ajaxSentInfoForm();

    function ajaxSentInfoForm(){

        $.ajax({
            type: 'GET',
            url: '/infoCh',
            data: $('#infoFormId').serialize(),
            success: function(data){
                alert('success '+ data);
                if(data!=1 && data!=0){
                    $('.translucent-form-overlay').remove();
                    $('#formB').append(data);
                }else if (data==0){
                    $('.translucent-form-overlay').remove();
                    window.location.href = "/log/";
                }
            }
        });
    }

});
$(document).ready(function () {
    $('#toolBarInfo').on('click', function(){
        var cookie = $.cookie("timestamp");
        var cookie2 = $.cookie("auth");
        alert(cookie);
        alert(cookie2);

        // if (cookie==1){
        ajaxRequest();
        // }else {
        //     window.location.href = "/log/";
        // }
    });
});

function ajaxRequest(){

    $.ajax({
        type: 'GET',
        url: '/showInfo',
        // data: {'s': term},
        success: function(data){
            $('#formB').append(data);
        }
    });
}
