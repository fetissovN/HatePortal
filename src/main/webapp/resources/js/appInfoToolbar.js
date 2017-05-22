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
    $('#toolBarInfo').click(function(){
        // var cookie = $.cookie("auth");
        // alert(cookie);
        //
        // if (cookie!=null){
        ajaxRequest();
        // }else {
        //
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
            // var myDiv = document.createElement('button');
            // myDiv.id = 'submitInfo';
            // document.body.appendChild(myDiv);
            // // document.getElementById('myDiv').innerHTML = 'this should have worked...';
            // document.createElement('submitInfo');

        }
    });
}
