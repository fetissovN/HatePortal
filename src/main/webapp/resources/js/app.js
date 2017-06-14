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
    $('#submitForm').click(function (e) {
        // e.preventDefault();
        // alert('in');
        $.ajax({
            type: 'GET',
            url: '/post/create',
            data: $('#form').serialize(),
            success: function(data){

                // todo
                // nodeNames = [];
                // $.each( f, function( i, el ) {
                //     nodeNames[ i ] = "<li>" + el.nodeName + "</li>";
                // });
                // alert(nodeNames);
            }
        });


        $('#form').css("display", "none");
    });
    //likes post
    $('#like').click(function (e) {
        var addressValue = $(this).attr("href");
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
    //page ajax load posts
    $('body').on('click', '#ajaxLoadPosts', function(){
        var page = $('#ajaxLoadPosts').attr("name");
        var countPage = parseInt(page);
        countPage++;
        $('#ajaxLoadPosts').remove();
        $.ajax({
            type: 'GET',
            url: '/loadPosts',
            data: {'page': countPage},
            success: function(data){
                countPage--;
                $('.loadedPostsPlaceholder'+page).append(data);
            }
        });

    });
    $('#ajaxLoadPosts').click(function () {

    });
});

