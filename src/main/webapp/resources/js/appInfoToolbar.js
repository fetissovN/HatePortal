$('#submitInfo').click(function (e) {
    e.preventDefault();
    alert('test');
    ajaxSentInfoForm();
});
$(document).ready(function () {
    $('#toolBarInfo').click(function(){
        ajaxRequest();
    });
    $('#submitInfo').click(function (e) {
        e.preventDefault();
        alert('test');
        ajaxSentInfoForm();
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
function ajaxSentInfoForm(){

    $.ajax({
        type: 'GET',
        url: '/infoCh',
        // data: {'s': term},
        success: function(data){
            alert(data);
            $('.translucent-form-overlay').remove();
        }
    });
}
