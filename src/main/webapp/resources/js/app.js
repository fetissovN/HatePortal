$(document).ready(function () {
    //show hide post form
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
    if (localStorage.getItem('show')== '1'){
        $('#form').show('fast');
    }else {
        $('#form').css("display", "none");
    }
    //hide post form after ok
    $('#submitForm').click(function () {
        $('#form').css("display", "none");
    });
    //likes
    $('#like').click(function (e) {
        var addressValue = $(this).attr("href");
        // alert(addressValue);
        e.preventDefault();
        $.ajax({
            type: 'GET',
            url: addressValue,
            // data: {'s': term},
            success: function(data){
                var likeT = $('#likeTag').text();
                var likeWS = likeT.replace(/\s+/g, '');
                var count = likeWS.substring(6,10);
                var countD = count.parseInt(count);
                var output = [likeWS.slice(0, 6),777, likeWS.slice(6)].join('');
                alert(countD)
                alert(count);
                alert(output);
            alert('success');
            }
        });
    });
});

