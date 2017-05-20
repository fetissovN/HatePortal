$('body').on('click', '#submitInfo', function(e){
    e.preventDefault();
    // $('#submitInfo').click(function (e) {
    //     e.preventDefault();
        ajaxSentInfoForm();
    // });
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
        // var sess = $.at;
        // alert(sess);
        // if (sess!=null){
            ajaxRequest();
        // }else {
        //     alert('err');
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
