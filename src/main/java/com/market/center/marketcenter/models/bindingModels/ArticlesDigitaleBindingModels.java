package com.market.center.marketcenter.models.bindingModels;


import com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration;
import com.market.center.marketcenter.models.entity.enumerationsProductsCategories.ProductsCategoryEnumerations;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ArticlesDigitaleBindingModels {

    private String title;
    private String shortFrontName;
    private String shortFrontDescription;
    private String secondTitle;
    private String hook;
    private String itemCode;
    private String description;
//    private Integer quantity;
//    private BigDecimal price;
    private String imgUrl;
    private String partnerUrl;
    private ProductsCategoryEnumerations category;
    private DigitaleProdukteEnumeration digitaleProdukteEnumeration;


    private String metaTitle;
    private String metaKeywords;
    private String metaDescriptions;


    public ArticlesDigitaleBindingModels() {
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getTitle() {
        return title;
    }

    public ArticlesDigitaleBindingModels setTitle(String title) {
        this.title = title;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getShortFrontName() {
        return shortFrontName;
    }

    public ArticlesDigitaleBindingModels setShortFrontName(String shortFrontName) {
        this.shortFrontName = shortFrontName;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getShortFrontDescription() {
        return shortFrontDescription;
    }

    public ArticlesDigitaleBindingModels setShortFrontDescription(String shortFrontDescription) {
        this.shortFrontDescription = shortFrontDescription;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getSecondTitle() {
        return secondTitle;
    }

    public ArticlesDigitaleBindingModels setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getHook() {
        return hook;
    }

    public ArticlesDigitaleBindingModels setHook(String hook) {
        this.hook = hook;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getItemCode() {
        return itemCode;
    }

    public ArticlesDigitaleBindingModels setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    @Size(min = 3, message = "The field must be minimum 3 characters!")
    public String getDescription() {
        return description;
    }

    public ArticlesDigitaleBindingModels setDescription(String description) {
        this.description = description;
        return this;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public ArticlesDigitaleBindingModels setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }


    public String getPartnerUrl() {
        return partnerUrl;
    }

    public ArticlesDigitaleBindingModels setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
        return this;
    }

    public ProductsCategoryEnumerations getCategory() {
        return category;
    }

    public ArticlesDigitaleBindingModels setCategory(ProductsCategoryEnumerations category) {
        this.category = category;
        return this;
    }

    public DigitaleProdukteEnumeration getDigitaleProdukteEnumeration() {
        return digitaleProdukteEnumeration;
    }

    public ArticlesDigitaleBindingModels setDigitaleProdukteEnumeration(DigitaleProdukteEnumeration digitaleProdukteEnumeration) {
        this.digitaleProdukteEnumeration = digitaleProdukteEnumeration;
        return this;
    }


    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescriptions() {
        return metaDescriptions;
    }

    public void setMetaDescriptions(String metaDescriptions) {
        this.metaDescriptions = metaDescriptions;
    }
}
