package com.arkarzaw.asartaline.datas.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarDeeVO implements BaseVO {

    @SerializedName("warDeeId")
    String warDeeId;

    String name;

    List<String> images;

    @SerializedName("generalTaste")
    List<GeneralTasteVO> generalTasteVOS;

    @SerializedName("suitedFor")
    List<SuitedForVO> suitedForVOS;

    int priceRangeMin;

    int priceRangeMax;

    @SerializedName("matchWarDeeList")
    List<MatchWarDeeVO> matchWarDeeVOS;

    @SerializedName("shopByDistance")
    List<ShopByDistanceVO> shopByDistanceVOS;

    @SerializedName("shopByPopularity")
    List<ShopByPopularityVO> shopByPopularityVOS;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTasteVOS() {
        return generalTasteVOS;
    }

    public List<SuitedForVO> getSuitedForVOS() {
        return suitedForVOS;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeVO> getMatchWarDeeVOS() {
        return matchWarDeeVOS;
    }

    public List<ShopByDistanceVO> getShopByDistanceVOS() {
        return shopByDistanceVOS;
    }

    public List<ShopByPopularityVO> getShopByPopularityVOS() {
        return shopByPopularityVOS;
    }
}
