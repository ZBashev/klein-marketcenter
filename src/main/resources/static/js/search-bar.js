const articlesList = document.getElementById('articlesList');
const searchBar = document.getElementById('searchInput');
const allArticles = [];


fetch("https://market-center.de/search/all-articles")
     .then(response => response.json())
    .then(data => {
        for (let d of data) {
            allArticles.push(d);
        }
    });

console.log(allArticles);

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    console.log(allArticles);
    let filteredArticles = allArticles.filter(articles => {
        return articles.title.toLowerCase().includes(searchingCharacters)
            || articles.itemCode.toLowerCase().includes(searchingCharacters)
            || articles.category.toLowerCase().includes(searchingCharacters)
            || articles.secondTitle.toLowerCase().includes(searchingCharacters)
            || articles.hook.toLowerCase().includes(searchingCharacters);
    });
    console.log(filteredArticles);
    displayArticles(filteredArticles);
});


const displayArticles = (article) => {


    articlesList.innerHTML = article
        .map((a) => {
            return `<div class="col-md-3" >
              <div class="card mb-4 box-shadow">
                <img src="${a.imgUrl}" class="card-img-top" alt="Thumbnail [100%x225]"
                     data-holder-rendered="true" loading="lazy"
                     style="height: 250px; width: 100%; display: block;">
                <div class="card-body">
                    <div class="text-center">
                        <p class="card-text   border-bottom ">${a.shortFrontName}</p>
                        <p class="card-text   border-bottom ">${a.shortFrontDescription}</p>
                         
                      

                     </div>
                    <div class="d-flex justify-content-between align-items-center">

                        <div class="btn-group">
                            <a href="/article/details/${a.id}"  type="button" class="btn btn-sm btn-outline-secondary">
                            Beschreibung</a>
                        </div>
                       

                    </div>
                </div>
              </div>
            </div>`
        })
        .join('');

}


