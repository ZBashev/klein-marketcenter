const amazonStacHr = document.getElementById('amazonItem');
const amazonListHr = [];

console.log(amazonListHr + "amazonListHr");



fetch(getUrl(textElement))


    .then(response => response.json())
    .then((json) => json.forEach((amazArticles) => {

        amazonListHr.push(amazArticles);
        console.log(amazonListHr);

        amazonStacHr.innerHTML = amazonListHr
            .map((a) => {
                return `
             <div class="col-xl-3 col-lg-4 col-md-4 col-xs-6 col-sm-6 col-11 mx-auto mx-sm-0 mx-md-0 mx-lg-0 mx-xl-0 mb-3">
              <div class="card h-100 mb-4 box-shadow card-litle"  >
              
              
              
              
              <div  class="card-img-top-amazon"   data-holder-rendered="true"   > 
                <span   id ="picture-amazon">${a.imgUrl}</span>     
                 
                 </div>
                
                 
                 
                  
                 <div class="card-body">
                    <div class="text-center">
                        <p class="card-text    border-bottom ">${a.titleH2}</p>
                         
                        <p class="card-text border-bottom    "> price : ${a.price}</p>
                        
                        
                       <p class="card-text  border-bottom  "> ${a.numberOfVotes}
                          <br>
                              <span  > ${a.stars}
                            <br>
                        
                               <span class="card-text"> ${a.bewertung} </span>
                         
                               
                         
                        </p>
                        

                    
                     </div>
                     
                     <table id="buttons-little-card">
                    
                     <div class="d-flex justify-content-between align-items-center">
                     
                     <tr>

                       <td >
                      
                        <div class="button-card "  >
                            <a target="_blank"   
 
                            href="${a.partnerUrl}" rel="nofollow" class="btn btn-link" type="button"  >zur Angebot
                            </a>
                           
                       
                        </div>
                       </td>
                     </tr>
                     
                     
                                    <tr>
                                        <td id="zwischen">
                                            <p>oder</p>
                                        </td>
                                    </tr>
                                
                       <tr>
                         <td>
                          <a href="/details/artikles/${a.id}" class="btn btn-link" type="button" >Weitere Informationen
                            </a>
                            
                            
                            
                          </td>
                        </tr>


                      </table>
                           
                         
 
                        
                        
                    </div>
                 </div>
                      
                     
                     
                     
              </div>    
              
              
              
                    
                    
                    
                  
                  
               
              
           </div>`

            })
            .join('');


    }));






