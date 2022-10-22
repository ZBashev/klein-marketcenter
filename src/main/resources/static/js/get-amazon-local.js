const amazonProdukteName = document.getElementById('amazon-card').textContent;


function getAmazonUrl(amazonProdukteName) {


    let fetchAmazonUrl = ' ';


    switch (amazonProdukteName) {


        case'SCHUHE':


            fetchAmazonUrl = "http://localhost:8081/show/amazon_schuhe";


            break;


        case 'LAPTOP':
            console.log("seisse")
            break;


        case 'E-Book-Amazon'
        :

            fetchAmazonUrl = "http://localhost:8080/show/e_book";
            break;


    }


    return fetchAmazonUrl;

}