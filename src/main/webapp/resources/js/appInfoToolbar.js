$('body').on('click', '#submitInfo', function(e){
    e.preventDefault();
    $('#submitInfo').click(function (e) {
        e.preventDefault();
        alert('test');
        ajaxSentInfoForm();
    });
    function ajaxSentInfoForm(){

        $.ajax({
            type: 'GET',
            url: '/infoCh',
            data: $('#infoFormId').serialize(),
            success: function(data){
                alert(data);
                $('.translucent-form-overlay').remove();
            }
        });
    }

});
$(document).ready(function () {
    $('#toolBarInfo').click(function(){
            ajaxRequest();
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
