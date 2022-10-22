jQuery(document).ready(function($) {
    var hideAndShow = function() {
        var ww = document.body.clientWidth;
        // get the text value from the h1 with ID title-card and assign it to the h4 without dublicating the ID
        $('.smallDevices').text($('.bigDevices').text());
        // set both h1 and h4 hidden attribute to true
        $('.bigDevices').attr("hidden",true);
        $('.smallDevices').attr("hidden",true);

        if (ww >=  768) {
            //if the device is laptop or desktop then display the h1 and remain h4 hidden
            $('.bigDevices').removeAttr('hidden');
        } else {
            //if the device is mobile then display the h4 and remain the h1 hidden
            $('.smallDevices').removeAttr('hidden');
        };
    };
    $(window).resize(function(){
        hideAndShow();
    });
    hideAndShow();
});