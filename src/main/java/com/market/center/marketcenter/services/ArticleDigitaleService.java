package com.market.center.marketcenter.services;



import com.market.center.marketcenter.models.bindingModels.ArticlesDigitaleBindingModels;
import com.market.center.marketcenter.models.entity.ArticleDigitaleEntity;
import com.market.center.marketcenter.models.serviceModels.UpdateDiagitaleArtServiceModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleDigitaleService {


    void addNewDigitaleArticles(ArticlesDigitaleBindingModels articlesDigitaleBindingModels);

    ResponseEntity<List<ArticleDigitaleViewModel>> findAllWinDigitaleProdukte();

    ArticleDigitaleViewModel findArticleById(String id);

    ArticleDigitaleEntity findArticleEntityById(String id);

    void deleteArticles(String id);

    void updateDigitaleArticle(UpdateDiagitaleArtServiceModel updateDiagitaleArtServiceModel);

    ResponseEntity<List<ArticleViewModel>> findAllArticlesApi();


    ResponseEntity<List<ArticleDigitaleViewModel>> findAllPsichologieProduckte();

    ResponseEntity<List<ArticleDigitaleViewModel>> findAllRechtUndGesetz();

    ResponseEntity<List<ArticleDigitaleViewModel>> findDatingArticles();

    ResponseEntity<List<ArticleDigitaleViewModel>> findAllCategoryByEnum(Enum enumeration);

    boolean findArticleByItemCode(String itemCode);

    ArticleDigitaleViewModel findAtricleByItemCode(String itemCode);

    ResponseEntity<ArticleDigitaleEntity> findResponsArticleBy(String id);
}
