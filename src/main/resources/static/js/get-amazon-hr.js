const textElement = document.getElementById('amazon-card').textContent;

console.log(textElement + " " + " textElement get-amazon-hr")

function getUrl(textElement) {


    let urlAddress = ' ';


    switch (textElement) {


        case'SCHUHE':


            urlAddress = "http://31.13.195.185:8081/show/amazon_schuhe";


            break;


        case 'LAPTOP':
            console.log("seisse")
            break;


        case 'E-Book-Amazon'
        :

            urlAddress = "http://31.13.195.185:8081/show/e_book";
            break;


    }


    return urlAddress;

}