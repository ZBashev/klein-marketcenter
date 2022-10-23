package com.market.center.marketcenter.services.impl;


import com.market.center.marketcenter.models.bindingModels.ArticlesDigitaleBindingModels;
import com.market.center.marketcenter.models.entity.ArticleDigitaleEntity;
import com.market.center.marketcenter.models.serviceModels.UpdateDiagitaleArtServiceModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleViewModel;
import com.market.center.marketcenter.repositoies.ArticleDigitaleRepository;
import com.market.center.marketcenter.services.ArticleDigitaleService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class ArticleDigitaleServiceImpl implements ArticleDigitaleService {

    private final ModelMapper modelMapper;
    private final ArticleDigitaleRepository articleDigitaleRepository;


    public ArticleDigitaleServiceImpl(ModelMapper modelMapper, ArticleDigitaleRepository articleDigitaleRepository
    ) {
        this.modelMapper = modelMapper;
        this.articleDigitaleRepository = articleDigitaleRepository;

    }


    @Override
    @Transactional
    public void addNewDigitaleArticles(ArticlesDigitaleBindingModels articlesDigitaleBindingModels) {


        ArticleDigitaleEntity articleDigitaleEntity = this.modelMapper.map(

                articlesDigitaleBindingModels, ArticleDigitaleEntity.class

        );


        StringBuilder builder = new StringBuilder();


        builder.append(this.buildItemCodeWhitWortMethodFirst(articlesDigitaleBindingModels));


        this.buidlItemCodeWithNumerMethodeTwo(builder, articleDigitaleEntity, articlesDigitaleBindingModels);


        this.articleDigitaleRepository.save(articleDigitaleEntity);


    }


    @Override
    public ResponseEntity<List<ArticleDigitaleViewModel>> findAllWinDigitaleProdukte() {


        List<ArticleDigitaleViewModel> articleViewModelList = new ArrayList<>();

        this.articleDigitaleRepository
                .findAll()
                .forEach(ade -> {

                    if (ade.getDigitaleProdukteEnumeration().name().contains("ONLINE_VERDIENEN")) {


                        ArticleDigitaleViewModel article = this.modelMapper.map(
                                ade, ArticleDigitaleViewModel.class
                        );

                        articleViewModelList.add(article);


                    }
                });


        return ResponseEntity
                .ok()


                .body(articleViewModelList);
    }

    @Override
    public ArticleDigitaleViewModel findArticleById(String id) {


 ArticleDigitaleViewModel art= this.articleDigitaleRepository.findById(id)
         .map(a -> modelMapper.map(a,ArticleDigitaleViewModel.class)).orElseThrow();


        return art;


//        ArticleDigitaleEntity article =this.articleDigitaleRepository.findEntityById(id);




//        Optional<ArticleDigitaleEntity> article = this.articleDigitaleRepository.findById(id);
//         ArticleDigitaleEntity  article = this.articleDigitaleRepository.findById(id).orElseThrow(IllegalArgumentException::new);


//        return this.modelMapper.map(article, ArticleDigitaleViewModel.class);


    }

    @Override
    public ArticleDigitaleEntity findArticleEntityById(String id) {
        return this.articleDigitaleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteArticles(String id) {


        this.articleDigitaleRepository.deleteById(id);
    }

    @Override
    public void updateDigitaleArticle(UpdateDiagitaleArtServiceModel updateDiagitaleArtServiceModel) {


        ArticleDigitaleEntity article = this.articleDigitaleRepository
                .findAtricleByItemCode(updateDiagitaleArtServiceModel.getItemCode());


        article.setTitle(updateDiagitaleArtServiceModel.getTitle());
        article.setShortFrontName(updateDiagitaleArtServiceModel.getShortFrontName());
        article.setShortFrontDescription(updateDiagitaleArtServiceModel.getShortFrontDescription());
        article.setSecondTitle(updateDiagitaleArtServiceModel.getSecondTitle());
        article.setHook(updateDiagitaleArtServiceModel.getHook());

        article.setImgUrl(updateDiagitaleArtServiceModel.getImgUrl());
        article.setCategory(updateDiagitaleArtServiceModel.getCategory());
        article.setDigitaleProdukteEnumeration(updateDiagitaleArtServiceModel.getDigitaleProdukteEnumeration());
        article.setDescription(updateDiagitaleArtServiceModel.getDescription());

        article.setPartnerUrl(updateDiagitaleArtServiceModel.getPartnerUrl());
        article.setMetaTitle(updateDiagitaleArtServiceModel.getMetaTitle());
        article.setMetaKeywords(updateDiagitaleArtServiceModel.getMetaKeywords());
        article.setMetaDescriptions(updateDiagitaleArtServiceModel.getMetaDescriptions());

        this.articleDigitaleRepository.saveAndFlush(article);

    }

    @Override
    public ResponseEntity<List<ArticleViewModel>> findAllArticlesApi() {


        List<ArticleViewModel> articleList = new ArrayList<>();

        this.articleDigitaleRepository.findAll()
                .forEach(f -> {
                    ArticleViewModel articleViewModel = this.modelMapper
                            .map(f, ArticleViewModel.class);

                    articleList.add(articleViewModel);
                });

        return ResponseEntity
                .ok()
                .body(articleList);
    }

    @Override
    public ResponseEntity<List<ArticleDigitaleViewModel>> findAllPsichologieProduckte() {


        List<ArticleDigitaleViewModel> articleList = new ArrayList<>();

        this.articleDigitaleRepository
                .findAll()
                .forEach(articleDigitaleEntity -> {

                    if (articleDigitaleEntity.getDigitaleProdukteEnumeration()
                            .name()
                            .contains("PSYCHOLOGIE_PERSÖNLICHKEITSENTWICKLUNG")) {


                        ArticleDigitaleViewModel article = this.modelMapper.map(
                                articleDigitaleEntity, ArticleDigitaleViewModel.class
                        );

                        articleList.add(article);


                    }
                });


        return ResponseEntity
                .ok()
                .body(articleList);
    }

    @Override
    public ResponseEntity<List<ArticleDigitaleViewModel>> findAllRechtUndGesetz() {


        List<ArticleDigitaleViewModel> articleList = new ArrayList<>();

        this.articleDigitaleRepository
                .findAll()
                .forEach(articleDigitaleEntity -> {

                    if (articleDigitaleEntity.getDigitaleProdukteEnumeration()
                            .name()
                            .contains("RECHT_UND_GESETZ")) {


                        ArticleDigitaleViewModel article = this.modelMapper.map(
                                articleDigitaleEntity, ArticleDigitaleViewModel.class
                        );

                        articleList.add(article);


                    }
                });


        return ResponseEntity
                .ok()
                .body(articleList);
    }

    @Override
    public ResponseEntity<List<ArticleDigitaleViewModel>> findDatingArticles() {
        List<ArticleDigitaleViewModel> articleList = new ArrayList<>();


        this.articleDigitaleRepository
                .findAll()
                .forEach(articleDigitaleEntity -> {

                    if (articleDigitaleEntity.getDigitaleProdukteEnumeration()
                            .name()
                            .contains("DATING_BEZIEHUNGEN_LIEBE")) {


                        ArticleDigitaleViewModel article = this.modelMapper.map(
                                articleDigitaleEntity, ArticleDigitaleViewModel.class
                        );

                        articleList.add(article);


                    }
                });


        return ResponseEntity
                .ok()
                .body(articleList);
    }

    @Override
    public ResponseEntity<List<ArticleDigitaleViewModel>> findAllCategoryByEnum(Enum enumeration) {


        List<ArticleDigitaleViewModel> articleList = new ArrayList<>();


        this.articleDigitaleRepository.findAllByDigitaleProdukteEnumeration(enumeration)
                .forEach(e -> {
                    ArticleDigitaleViewModel article;
                    article = this.modelMapper.map(e, ArticleDigitaleViewModel.class);

                    articleList.add(article);
                });


        return ResponseEntity
                .ok()
                .body(articleList);
    }

    @Override
    public boolean findArticleByItemCode(String item) {


        return this.articleDigitaleRepository.findByItemCode(item).isPresent();


    }

    @Override
    public ArticleDigitaleViewModel findAtricleByItemCode(String itemCode) {



        ArticleDigitaleEntity entity=    this.articleDigitaleRepository.findAtricleByItemCode(itemCode);

      return this.modelMapper.map(entity,ArticleDigitaleViewModel.class);



    }

    @Override
    public ResponseEntity<ArticleDigitaleEntity> findResponsArticleBy(String id) {





            ResponseEntity<ArticleDigitaleEntity>art=    this.articleDigitaleRepository.findArticleDigitaleEntityById(id) ;


return art;


    }

    private StringBuilder buildItemCodeWhitWortMethodFirst
            (ArticlesDigitaleBindingModels articlesDigitaleBindingModels) {

        StringBuilder builder = new StringBuilder();


        String[] categoryEnum = articlesDigitaleBindingModels.getCategory().toString().split("_");
        String[] productCategoryEnum =
                articlesDigitaleBindingModels.getDigitaleProdukteEnumeration().toString().split("_");

        int categoryNummer = categoryEnum.length;


        if (categoryNummer < 2) {

            builder.append(categoryEnum[0].charAt(0));
        } else {
            for (String s : categoryEnum) {

                builder.append(s.charAt(0));


            }
        }
        builder.append("_");

        int productNummer = productCategoryEnum.length;


        if (productNummer < 2) {

            builder.append(productCategoryEnum[0].charAt(0));
        } else {


            for (String j : productCategoryEnum) {


                if (j.length() < 2) {
                    builder.append(j.charAt(0));

                } else {
                    builder.append(j.charAt(0));
                    builder.append(j.charAt(1));
                }


            }


        }
        builder.append("_");


        return builder;
    }

    private ArticleDigitaleEntity buidlItemCodeWithNumerMethodeTwo(StringBuilder builder,
                                                                   ArticleDigitaleEntity articleDigitaleEntity,
                                                                   ArticlesDigitaleBindingModels articlesDigitaleBindingModels) {
        List<ArticleDigitaleEntity> numberOfArticlesList =
                articleDigitaleRepository
                        .findAllByDigitaleProdukteEnumeration(
                                articlesDigitaleBindingModels.getDigitaleProdukteEnumeration()
                        );


        long listSise = numberOfArticlesList.size();
        long num = listSise + 1;

        String itemCode;

        if (numberOfArticlesList.isEmpty()) {
            itemCode = builder.append("01").toString();


        } else {


            itemCode = builder.append(num).toString();


        }


        if (this.findArticleByItemCode(itemCode)) {


            itemCode = builder.append("_d").toString();
        }


        articleDigitaleEntity.setItemCode(itemCode);


        return articleDigitaleEntity;
    }
}
