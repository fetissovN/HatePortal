$(document).ready(function () {
    $('#adminLinkToPost').click(function(e){
        e.preventDefault();
        var link = $('#adminLinkToPost').attr("href");
        window.open(link);
    });

});

