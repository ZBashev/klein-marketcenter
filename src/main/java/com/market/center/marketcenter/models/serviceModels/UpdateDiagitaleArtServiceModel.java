package com.market.center.marketcenter.models.serviceModels;



import com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration;
import com.market.center.marketcenter.models.entity.enumerationsProductsCategories.ProductsCategoryEnumerations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class UpdateDiagitaleArtServiceModel {



    private String title;
    private String shortFrontName;
    private String shortFrontDescription;
    private String secondTitle;
    private String hook;
    private String itemCode;
    private String description;
  /*  private Integer quantity;
    private BigDecimal price;*/
    private String imgUrl;
    private String partnerUrl;
    private ProductsCategoryEnumerations category;
    private DigitaleProdukteEnumeration digitaleProdukteEnumeration;

    private String metaTitle;
    private String metaKeywords;
    private String metaDescriptions;







    public UpdateDiagitaleArtServiceModel() {
    }

@NotBlank()
@NotEmpty()
    public String getTitle() {
        return title;
    }

    public UpdateDiagitaleArtServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }
    @NotBlank()
    @NotEmpty()
    public String getShortFrontName() {
        return shortFrontName;
    }

    public UpdateDiagitaleArtServiceModel setShortFrontName(String shortFrontName) {
        this.shortFrontName = shortFrontName;
        return this;
    }
    @NotBlank()
    @NotEmpty()
    public String getShortFrontDescription() {
        return shortFrontDescription;
    }

    public UpdateDiagitaleArtServiceModel setShortFrontDescription(String shortFrontDescription) {
        this.shortFrontDescription = shortFrontDescription;
        return this;
    }
    @NotBlank()
    @NotEmpty()
    public String getSecondTitle() {
        return secondTitle;
    }

    public UpdateDiagitaleArtServiceModel setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
        return this;
    }
    @NotBlank()
    @NotEmpty()
    public String getHook() {
        return hook;
    }

    public UpdateDiagitaleArtServiceModel setHook(String hook) {
        this.hook = hook;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public UpdateDiagitaleArtServiceModel setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }
    @NotBlank()
    @NotEmpty()
    public String getDescription() {
        return description;
    }

    public UpdateDiagitaleArtServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

  /*  public Integer getQuantity() {
        return quantity;
    }

    public UpdateDiagitaleArtServiceModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UpdateDiagitaleArtServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }*/

    public String getImgUrl() {
        return imgUrl;
    }

    public UpdateDiagitaleArtServiceModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }


    public String getPartnerUrl() {
        return partnerUrl;
    }

    public UpdateDiagitaleArtServiceModel setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
        return this;
    }

    public ProductsCategoryEnumerations getCategory() {
        return category;
    }

    public UpdateDiagitaleArtServiceModel setCategory(ProductsCategoryEnumerations category) {
        this.category = category;
        return this;
    }

    public DigitaleProdukteEnumeration getDigitaleProdukteEnumeration() {
        return digitaleProdukteEnumeration;
    }

    public UpdateDiagitaleArtServiceModel setDigitaleProdukteEnumeration(DigitaleProdukteEnumeration digitaleProdukteEnumeration) {
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
