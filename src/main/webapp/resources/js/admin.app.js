$(document).ready(function () {
    $('#adminLinkToPost').click(function(e){
        e.preventDefault();
        var link = $('#adminLinkToPost').attr("href");

        window.open(link);
        // $('#form').show('slow');
        // var show = $('#form');
        // localStorage.setItem('show', '1');
    });

});

