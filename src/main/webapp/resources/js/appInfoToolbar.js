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
                $('.translucent-form-overlay').remove();
            }
        });
    }

});
$(document).ready(function () {
    $('#toolBarInfo').click(function(){
        var cookie = $.cookie("auth");
        alert(cookie);

        if (cookie!=null){
        ajaxRequest();
        }else {

        }


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
