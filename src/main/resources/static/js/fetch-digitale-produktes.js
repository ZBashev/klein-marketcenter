const articleList = document.getElementById('onlineWinList');
const allArticles = [];


fetch(getUrlByTitle(titleName))

    .then(response => response.json())
    .then((json) => json.forEach((articles) => {

        allArticles.push(articles);
        console.log(allArticles);

        articleList.innerHTML = allArticles
            .map((a) => {
                return `
            <div class="col-xl-3 col-lg-4 col-md-4 col-xs-6 col-sm-6 col-11 mx-auto mx-sm-0 mx-md-0 mx-lg-0 mx-xl-0 mb-3">
                <div class="card h-100 mb-5 box-shadow card-litle">
                <a target="_blank" href="${a.partnerUrl}" rel="nofollow" >
                  <img src="${a.imgUrl}" class="img-fluid card-img-top" loading="lazy" alt="${a.title} [100%x225]"
                     data-holder-rendered="true"
                     style="height:10.5rem; width: 100%; display: block;">
                </a>
                  
                <div class="card-body">
                    <div class="text-center">
                        <p class="card-text border-bottom ">${a.shortFrontName}</p>
                        <p class="card-text">  ${a.shortFrontDescription}</p>
                     </div>
                     
                 </div>    
                     
                     <div id="buttons-little-card">
                        <div class="d-flex align-items-center text-center">
                      
                       
                       
<!--                        <div class="button-card text-center mx-auto mt-2 mb-2"> -->
                        <div class="button-card text-center mx-auto sm-2 pt-2"> 
                            <a target="_blank"   
                            href="${a.partnerUrl}" rel="nofollow" class="btn btn-link text-center mx-auto" type="button" >zur Angebot
                            </a>
<!--                        </div>-->
                      
                   
<!--                        <td id="zwischen" class="mt-2 mb-2">-->
                          <div id="zwischen" class="sm-2 pt-2">
                            <p>oder</p>
                          </div>
                      
                            <a href="/article/detail/${a.id}" class="btn btn-link" type="button" >Weitere Informationen</a>    
                           
                        </div> 
                      </div>  
                    </div>
                    
                    
                    
<!--                 </div>   -->
              </div>    
            </div>`
            })
            .join('');


    }));






