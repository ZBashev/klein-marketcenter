package com.market.center.marketcenter.models.entity;


import com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration;
import com.market.center.marketcenter.models.entity.enumerationsProductsCategories.ProductsCategoryEnumerations;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "articles")
public class ArticleDigitaleEntity extends BaseEntity {


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


    public ArticleDigitaleEntity() {
    }

    @Column(name = "titles")
    public String getTitle() {
        return title;
    }

    public ArticleDigitaleEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(name = "short_front_name", columnDefinition = "TEXT")
    public String getShortFrontName() {
        return shortFrontName;
    }

    public ArticleDigitaleEntity setShortFrontName(String shortFrontName) {
        this.shortFrontName = shortFrontName;
        return this;
    }

    @Column(name = "short_front_descriptions", columnDefinition = "TEXT")
    public String getShortFrontDescription() {
        return shortFrontDescription;
    }

    public ArticleDigitaleEntity setShortFrontDescription(String shortFrontDescription) {
        this.shortFrontDescription = shortFrontDescription;
        return this;
    }

    @Column(name = "second_titiles")
    public String getSecondTitle() {
        return secondTitle;
    }

    public ArticleDigitaleEntity setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
        return this;
    }

    @Column(name = "hooks")
    public String getHook() {
        return hook;
    }

    public ArticleDigitaleEntity setHook(String hook) {
        this.hook = hook;
        return this;
    }

    @Column(name = "item_codes", unique = true)
    public String getItemCode() {
        return itemCode;
    }

    public ArticleDigitaleEntity setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    @Column(name = "descriptions", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public ArticleDigitaleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

//    @Column(name = "quantity")
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public ArticleDigitaleEntity setQuantity(Integer quantity) {
//        this.quantity = quantity;
//        return this;
//    }
//
//    @Column(name = "price")
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public ArticleDigitaleEntity setPrice(BigDecimal price) {
//        this.price = price;
//        return this;
//    }

    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public ArticleDigitaleEntity setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @Column(name = "partner_url")
    public String getPartnerUrl() {
        return partnerUrl;
    }

    public ArticleDigitaleEntity setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
        return this;
    }

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    public ProductsCategoryEnumerations getCategory() {
        return category;
    }

    public ArticleDigitaleEntity setCategory(ProductsCategoryEnumerations category) {
        this.category = category;
        return this;
    }

    @Column(name = "digitale_produkte")
    @Enumerated(EnumType.STRING)
    public DigitaleProdukteEnumeration getDigitaleProdukteEnumeration() {
        return digitaleProdukteEnumeration;
    }

    public ArticleDigitaleEntity setDigitaleProdukteEnumeration(DigitaleProdukteEnumeration digitaleProdukteEnumeration) {
        this.digitaleProdukteEnumeration = digitaleProdukteEnumeration;
        return this;
    }

    @Column
    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @Column
    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    @Column
    public String getMetaDescriptions() {
        return metaDescriptions;
    }

    public void setMetaDescriptions(String metaDescriptions) {
        this.metaDescriptions = metaDescriptions;
    }
}
