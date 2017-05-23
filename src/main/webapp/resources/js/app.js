$(document).ready(function () {

    $('#postForm').click(function(){
        $('#form').show('slow');
        var show = $('#form');
        localStorage.setItem('show', '1');
    });
    $('#closePostForm').click(function () {
        $('#form').css("display", "none");
        var show = $('#form');
        localStorage.setItem('show', '0');
    });
    // $('#submitForm').click(function () {
    //
    // });
    //TODO above
    if (localStorage.getItem('show')== '1'){
        $('#form').show('fast');
    }else {
        $('#form').css("display", "none");
    }
    // $('#log').click(function () {
    //     alert('asd');
    //     $.removeCookie('auth', { path: '/' });
    // })
});

