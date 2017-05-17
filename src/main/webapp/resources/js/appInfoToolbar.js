$(document).ready(function () {
    $('#toolBarInfo').click(function(){
        // var term = $.session.get('auth');

        // var term = '1';
        ajaxRequest();
    });
});

function ajaxRequest(){

    $.ajax({
        type: 'GET',
        url: '/showInfo',
        // data: {'s': term},
        success: function(data){
            alert('asdasd');
            $('#formB').append(data);
        }


    });
}
