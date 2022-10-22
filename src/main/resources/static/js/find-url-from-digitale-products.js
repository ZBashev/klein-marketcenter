const titleName = document.getElementById('title-card').accessKey;


function getUrlByTitle(tileName) {


    let urlFetch = ' ';


    switch
        (tileName) {


        case
        'ONLINE VERDIENEN'
        :

            urlFetch = "http://31.13.195.185:8081/view/all-win-produkte";



            break;


        case
        'PSYCHOLOGIE & PERSÖNLICHKEITSENTWICKLUNG'
        :

            urlFetch = "http://31.13.195.185:8081/view/psychologie";

            break;


        case
        'RECHT UND GESETZ'
        :


            urlFetch = 'http://31.13.195.185:8081/view/recht-gesetz';


            break;


        case
        "DATING,BEZIEHUNGEN UND LIEBE"
        :


            urlFetch = 'http://31.13.195.185:8081/view/dating';
            break;

        case
        'SPRACHE LERNEN'
        :

            urlFetch = 'http://31.13.195.185:8081/view/sprache';

            break;

        case
        'CDF - FOREX - BITCOIN'
        :

            urlFetch = 'http://31.13.195.185:8081/view/forex';
            break;


        case
        'WETTSYSTEME'
        :

            urlFetch = 'http://31.13.195.185:8081/view/wettsysteme';
            break;


        case
        'E-Book'
        :

            urlFetch = "http://31.13.195.185:8081/view/ebook";

            break;

        case
        'Essen & Gesundheit'
        :

            urlFetch = "http://31.13.195.185:8081/view/essen";

            break;
    }
    return urlFetch;
}