package com.market.center.marketcenter.models.serviceViewModels;




import com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration;
import com.market.center.marketcenter.models.entity.enumerationsProductsCategories.ProductsCategoryEnumerations;

import java.math.BigDecimal;

public class ArticleViewModel {


    private String id;
    private String title;
    private String shortFrontName;
    private String shortFrontDescription;
    private String secondTitle;
    private String hook;
    private String itemCode;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private String imgUrl;
    private ProductsCategoryEnumerations category;
    private DigitaleProdukteEnumeration digitaleProdukteEnumeration;




    private String metaTitle;
    private String metaKeywords;
    private String metaDescriptions;



    public ArticleViewModel() {
    }


    public String getId() {
        return id;
    }

    public ArticleViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getShortFrontName() {
        return shortFrontName;
    }

    public ArticleViewModel setShortFrontName(String shortFrontName) {
        this.shortFrontName = shortFrontName;
        return this;
    }

    public String getShortFrontDescription() {
        return shortFrontDescription;
    }

    public ArticleViewModel setShortFrontDescription(String shortFrontDescription) {
        this.shortFrontDescription = shortFrontDescription;
        return this;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public ArticleViewModel setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
        return this;
    }

    public String getHook() {
        return hook;
    }

    public ArticleViewModel setHook(String hook) {
        this.hook = hook;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public ArticleViewModel setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ArticleViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ArticleViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ArticleViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public ProductsCategoryEnumerations getCategory() {
        return category;
    }

    public ArticleViewModel setCategory(ProductsCategoryEnumerations category) {
        this.category = category;
        return this;
    }


    public DigitaleProdukteEnumeration getDigitaleProdukteEnumeration() {
        return digitaleProdukteEnumeration;
    }

    public void setDigitaleProdukteEnumeration(DigitaleProdukteEnumeration digitaleProdukteEnumeration) {
        this.digitaleProdukteEnumeration = digitaleProdukteEnumeration;
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
