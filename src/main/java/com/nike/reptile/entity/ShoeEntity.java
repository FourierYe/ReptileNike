package com.nike.reptile.entity;

import java.util.Objects;

/**
 * @program: reptile
 * @description: 鞋子实体类
 * @author: Geekye
 * @create: 2018-12-03 17:00
 **/
public class ShoeEntity {

    /**
     * inWallContentCard : false
     * rawPrice : 349
     * localPrice : ￥349
     * overriddenLocalPrice : ￥499
     * employeePrice : ￥349
     * overriddenEmployeePrice : ￥499
     * title : Nike Flex Control II
     * subtitle : 男子训练鞋（健身与训练）
     * nikeid : false
     * nikeIdPremiumImage : false
     * nfl : false
     * nba : false
     * jersey : false
     * playerNamesAvailable : false
     * widthsAvailable : false
     * inStock : true
     * comingSoon : false
     * preorder : false
     * pdpUrl : https://www.nike.com/cn/t/flex-control-2-%E7%94%B7%E5%AD%90%E8%AE%AD%E7%BB%83%E9%9E%8B%EF%BC%88%E5%81%A5%E8%BA%AB%E4%B8%8E%E8%AE%AD%E7%BB%83%EF%BC%89-js0Cg7
     * spriteSheet : https://images.nike.com/is/image/DotCom/pwp_sheet2?$NIKE_PWPx3$&$img0=924204_010&$img1=924204_400
     * fullSize : true
     * numberOfColors : 2
     * showNumberOfColors : true
     * itemIndex : 421
     * colorways : [{"inWallContentCard":false,"rawPrice":349,"localPrice":"￥349","overriddenLocalPrice":"￥499","employeePrice":"￥349","overriddenEmployeePrice":"￥499","pdpUrl":"https://www.nike.com/cn/t/flex-control-2-%E7%94%B7%E5%AD%90%E8%AE%AD%E7%BB%83%E9%9E%8B%EF%BC%88%E5%81%A5%E8%BA%AB%E4%B8%8E%E8%AE%AD%E7%BB%83%EF%BC%89-js0Cg7","imageUrl":"https://images.nike.com/is/image/DotCom/pwp_sheet2?$NIKE_PWPx3$&$img0=924204_010&$img1=924204_400","inStock":true,"comingSoon":false,"preorder":false,"colorDescription":"Black","salesChannel":["Nike.com"],"abTest":null},{"inWallContentCard":false,"rawPrice":349,"localPrice":"￥349","overriddenLocalPrice":"￥499","employeePrice":"￥349","overriddenEmployeePrice":"￥499","pdpUrl":"https://www.nike.com/cn/t/flex-control-2-%E7%94%B7%E5%AD%90%E8%AE%AD%E7%BB%83%E9%9E%8B%EF%BC%88%E5%81%A5%E8%BA%AB%E4%B8%8E%E8%AE%AD%E7%BB%83%EF%BC%89-js0Cg7/924204-400","imageUrl":"https://images.nike.com/is/image/DotCom/pwp_sheet2?$NIKE_PWPx3$&$img0=924204_010&$img1=924204_400","inStock":true,"comingSoon":false,"preorder":false,"colorDescription":"Blue","salesChannel":["Nike.com"],"abTest":null}]
     * showColorways : true
     * showReviews : true
     * showPrice : true
     * ratingCount : null
     * rating : null
     * teamName : null
     * maxAge : null
     * textBadge : null
     * gridType : standard
     * segmentNumber :
     * customizationtype :
     * customizable : false
     * salesChannel : ["Nike.com"]
     * abTest : null
     */

    private boolean inWallContentCard;
    private int rawPrice;
    private String localPrice;
    private String overriddenLocalPrice;
    private String employeePrice;
    private String overriddenEmployeePrice;
    private String title;
    private String subtitle;
    private boolean nikeid;
    private boolean nikeIdPremiumImage;
    private boolean nfl;
    private boolean nba;
    private boolean jersey;
    private boolean playerNamesAvailable;
    private boolean widthsAvailable;
    private boolean inStock;
    private boolean comingSoon;
    private boolean preorder;
    private String pdpUrl;
    private String spriteSheet;
    private boolean fullSize;
    private int numberOfColors;
    private boolean showNumberOfColors;
    private int itemIndex;
    private boolean showColorways;
    private boolean showReviews;
    private boolean showPrice;
    private String gridType;
    private boolean customizable;

    public boolean isInWallContentCard() {
        return inWallContentCard;
    }

    public void setInWallContentCard(boolean inWallContentCard) {
        this.inWallContentCard = inWallContentCard;
    }

    public int getRawPrice() {
        return rawPrice;
    }

    public void setRawPrice(int rawPrice) {
        this.rawPrice = rawPrice;
    }

    public String getLocalPrice() {
        return localPrice;
    }

    public void setLocalPrice(String localPrice) {
        this.localPrice = localPrice;
    }

    public String getOverriddenLocalPrice() {
        return overriddenLocalPrice;
    }

    public void setOverriddenLocalPrice(String overriddenLocalPrice) {
        this.overriddenLocalPrice = overriddenLocalPrice;
    }

    public String getEmployeePrice() {
        return employeePrice;
    }

    public void setEmployeePrice(String employeePrice) {
        this.employeePrice = employeePrice;
    }

    public String getOverriddenEmployeePrice() {
        return overriddenEmployeePrice;
    }

    public void setOverriddenEmployeePrice(String overriddenEmployeePrice) {
        this.overriddenEmployeePrice = overriddenEmployeePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isNikeid() {
        return nikeid;
    }

    public void setNikeid(boolean nikeid) {
        this.nikeid = nikeid;
    }

    public boolean isNikeIdPremiumImage() {
        return nikeIdPremiumImage;
    }

    public void setNikeIdPremiumImage(boolean nikeIdPremiumImage) {
        this.nikeIdPremiumImage = nikeIdPremiumImage;
    }

    public boolean isNfl() {
        return nfl;
    }

    public void setNfl(boolean nfl) {
        this.nfl = nfl;
    }

    public boolean isNba() {
        return nba;
    }

    public void setNba(boolean nba) {
        this.nba = nba;
    }

    public boolean isJersey() {
        return jersey;
    }

    public void setJersey(boolean jersey) {
        this.jersey = jersey;
    }

    public boolean isPlayerNamesAvailable() {
        return playerNamesAvailable;
    }

    public void setPlayerNamesAvailable(boolean playerNamesAvailable) {
        this.playerNamesAvailable = playerNamesAvailable;
    }

    public boolean isWidthsAvailable() {
        return widthsAvailable;
    }

    public void setWidthsAvailable(boolean widthsAvailable) {
        this.widthsAvailable = widthsAvailable;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isComingSoon() {
        return comingSoon;
    }

    public void setComingSoon(boolean comingSoon) {
        this.comingSoon = comingSoon;
    }

    public boolean isPreorder() {
        return preorder;
    }

    public void setPreorder(boolean preorder) {
        this.preorder = preorder;
    }

    public String getPdpUrl() {
        return pdpUrl;
    }

    public void setPdpUrl(String pdpUrl) {
        this.pdpUrl = pdpUrl;
    }

    public String getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(String spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public boolean isFullSize() {
        return fullSize;
    }

    public void setFullSize(boolean fullSize) {
        this.fullSize = fullSize;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    public boolean isShowNumberOfColors() {
        return showNumberOfColors;
    }

    public void setShowNumberOfColors(boolean showNumberOfColors) {
        this.showNumberOfColors = showNumberOfColors;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public boolean isShowColorways() {
        return showColorways;
    }

    public void setShowColorways(boolean showColorways) {
        this.showColorways = showColorways;
    }

    public boolean isShowReviews() {
        return showReviews;
    }

    public void setShowReviews(boolean showReviews) {
        this.showReviews = showReviews;
    }

    public boolean isShowPrice() {
        return showPrice;
    }

    public void setShowPrice(boolean showPrice) {
        this.showPrice = showPrice;
    }

    public String getGridType() {
        return gridType;
    }

    public void setGridType(String gridType) {
        this.gridType = gridType;
    }

    public boolean isCustomizable() {
        return customizable;
    }

    public void setCustomizable(boolean customizable) {
        this.customizable = customizable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoeEntity that = (ShoeEntity) o;
        return rawPrice == that.rawPrice &&
                nikeid == that.nikeid &&
                nikeIdPremiumImage == that.nikeIdPremiumImage &&
                Objects.equals(localPrice, that.localPrice) &&
                Objects.equals(overriddenLocalPrice, that.overriddenLocalPrice) &&
                Objects.equals(employeePrice, that.employeePrice) &&
                Objects.equals(overriddenEmployeePrice, that.overriddenEmployeePrice) &&
                Objects.equals(title, that.title) &&
                Objects.equals(subtitle, that.subtitle) &&
                Objects.equals(pdpUrl, that.pdpUrl) &&
                Objects.equals(spriteSheet, that.spriteSheet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rawPrice, localPrice, overriddenLocalPrice, employeePrice, overriddenEmployeePrice, title, subtitle, nikeid, nikeIdPremiumImage, pdpUrl, spriteSheet);
    }

    @Override
    public String toString() {
        return "ShoeEntity{" +
                "inWallContentCard=" + inWallContentCard +
                ", rawPrice=" + rawPrice +
                ", localPrice='" + localPrice + '\'' +
                ", overriddenLocalPrice='" + overriddenLocalPrice + '\'' +
                ", employeePrice='" + employeePrice + '\'' +
                ", overriddenEmployeePrice='" + overriddenEmployeePrice + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", nikeid=" + nikeid +
                ", nikeIdPremiumImage=" + nikeIdPremiumImage +
                ", nfl=" + nfl +
                ", nba=" + nba +
                ", jersey=" + jersey +
                ", playerNamesAvailable=" + playerNamesAvailable +
                ", widthsAvailable=" + widthsAvailable +
                ", inStock=" + inStock +
                ", comingSoon=" + comingSoon +
                ", preorder=" + preorder +
                ", pdpUrl='" + pdpUrl + '\'' +
                ", spriteSheet='" + spriteSheet + '\'' +
                ", fullSize=" + fullSize +
                ", numberOfColors=" + numberOfColors +
                ", showNumberOfColors=" + showNumberOfColors +
                ", itemIndex=" + itemIndex +
                ", showColorways=" + showColorways +
                ", showReviews=" + showReviews +
                ", showPrice=" + showPrice +
                ", gridType='" + gridType + '\'' +
                ", customizable=" + customizable +
                '}';
    }
}
