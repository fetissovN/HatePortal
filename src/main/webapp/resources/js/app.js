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
    //likes post
    $('#like').click(function (e) {
        var addressValue = $(this).attr("href");
        alert(addressValue);
        e.preventDefault();
        if (localStorage.getItem(addressValue)=='1'){
            alert('nooooo');
        }else {
            $.ajax({
                type: 'GET',
                url: addressValue,
                // data: {'s': term},
                success: function(data){
                    var likeT = $('#likeTag').text();
                    var likeWS = likeT.replace(/\s+/g, '');
                    var count = likeWS.substring(6,10);
                    var countD = parseInt(count);
                    countD = countD+1;
                    var output = [likeWS.slice(0, 6),countD, likeWS.slice(10)].join('');
                    $('#likeTag').html(output);
                    localStorage.setItem(addressValue, "1");
                }
            });
        }

    });
    //likes message
    $('#likeMessLink').click(function (e) {
        var addressValue = $(this).attr("href");
        alert(addressValue);
        e.preventDefault();
        if (localStorage.getItem(addressValue)=='1'){
            alert('nooooo');
        }else {
            $.ajax({
                type: 'GET',
                url: addressValue,
                success: function(data){
                    var likeT = $('#likeMessage').text();
                    var likeWS = likeT.replace(/\s+/g, '');
                    var count = likeWS.substring(6,10);
                    var countD = parseInt(count);
                    countD = countD+1;
                    var output = [likeWS.slice(0, 6),countD, likeWS.slice(10)].join('');
                    $('#likeMessage').html(output);
                    localStorage.setItem(addressValue, "1");
                }
            });
        }

    });
    // $('#ajaxLoadPosts').click(function () {
    //     var page = $('#ajaxLoadPosts').attr("name");
    //     alert(page);
    //     $('#ajaxLoadPosts').hide();
    //     $.ajax({
    //             type: 'GET',
    //             url: '/loadPosts',
    //             data: {'page': '1'},
    //             success: function(data){
    //             $('.loadedPostsPlaceholder').append(data);
    //             }
    //     });
    // });
    $('body').on('click', '#ajaxLoadPosts', function(){
        var page = $('#ajaxLoadPosts').attr("name");
        var countPage = parseInt(page);
        countPage++;
        alert(countPage);
        $('#ajaxLoadPosts').remove();
        $.ajax({
            type: 'GET',
            url: '/loadPosts',
            data: {'page': countPage},
            success: function(data){
                alert('kasjd');
                countPage--;
                $('.loadedPostsPlaceholder'+page).append(data);
            }
        });

    });
    $('#ajaxLoadPosts').click(function () {

    });
});

