const name = document.getElementById('title-card').accessKey;


function getLocalByTitle(name) {


    let local = ' ';


    switch (name) {


        case
        'ONLINE VERDIENEN'
        :

            local = "http://localhost:8081/view/all-win-produkte";


            break;


        case
        'PSYCHOLOGIE & PERSÖNLICHKEITSENTWICKLUNG'
        :

            local = "http://localhost:8081/view/psychologie";
            break;


        case
        'RECHT UND GESETZ'
        :


            local = "http://localhost:8081/view/recht-gesetz";

            break;


        case
        "DATING,BEZIEHUNGEN UND LIEBE"
        :


            local = "http://localhost:8081/view/dating";
            break;

        case
        'SPRACHE LERNEN'
        :

            local = "http://localhost:8081/view/sprache";
            break;

        case
        'CDF - FOREX - BITCOIN'
        :

            local = "http://localhost:8081/view/forex";
            break;


        case
        'WETTSYSTEME'
        :

            local = "http://localhost:8081/view/wettsysteme";
            break;


        case
        'E-Book'
        :

            local = "http://localhost:8081/view/ebook";

            break;

        case
        'Essen & Gesundheit'
        :

            local = "http://localhost:8081/view/essen";

            break;

    }
    return local;
}