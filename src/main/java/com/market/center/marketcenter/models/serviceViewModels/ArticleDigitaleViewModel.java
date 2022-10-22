package com.market.center.marketcenter.models.serviceViewModels;

;

import com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration;
import com.market.center.marketcenter.models.entity.enumerationsProductsCategories.ProductsCategoryEnumerations;

import java.math.BigDecimal;

public class ArticleDigitaleViewModel {

    private String id;
    private String title;
    private String shortFrontName;
    private String shortFrontDescription;
    private String secondTitle;
    private String hook;
    private String itemCode;
    private String description;
 /*   private Integer quantity;
    private BigDecimal price;*/
    private String imgUrl;
    private String partnerUrl;
    private ProductsCategoryEnumerations category;
    private DigitaleProdukteEnumeration digitaleProdukteEnumeration;


    private String metaTitle;
    private String metaKeywords;
    private String metaDescriptions;


    public ArticleDigitaleViewModel() {
    }


    public String getId() {
        return id;
    }

    public ArticleDigitaleViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleDigitaleViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getShortFrontName() {
        return shortFrontName;
    }

    public ArticleDigitaleViewModel setShortFrontName(String shortFrontName) {
        this.shortFrontName = shortFrontName;
        return this;
    }

    public String getShortFrontDescription() {
        return shortFrontDescription;
    }

    public ArticleDigitaleViewModel setShortFrontDescription(String shortFrontDescription) {
        this.shortFrontDescription = shortFrontDescription;
        return this;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public ArticleDigitaleViewModel setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
        return this;
    }

    public String getHook() {
        return hook;
    }

    public ArticleDigitaleViewModel setHook(String hook) {
        this.hook = hook;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public ArticleDigitaleViewModel setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleDigitaleViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
/*

    public Integer getQuantity() {
        return quantity;
    }

    public ArticleDigitaleViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ArticleDigitaleViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
*/

    public String getImgUrl() {
        return imgUrl;
    }

    public ArticleDigitaleViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }


    public String getPartnerUrl() {
        return partnerUrl;
    }

    public ArticleDigitaleViewModel setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
        return this;
    }

    public ProductsCategoryEnumerations getCategory() {
        return category;
    }

    public ArticleDigitaleViewModel setCategory(ProductsCategoryEnumerations category) {
        this.category = category;
        return this;
    }

    public DigitaleProdukteEnumeration getDigitaleProdukteEnumeration() {
        return digitaleProdukteEnumeration;
    }

    public ArticleDigitaleViewModel setDigitaleProdukteEnumeration(DigitaleProdukteEnumeration digitaleProdukteEnumeration) {
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
