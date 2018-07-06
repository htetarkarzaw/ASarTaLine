package com.arkarzaw.asartaline.datas.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVO implements BaseVO {

    String shopByDistanceId;

    @SerializedName("mealShop")
    MealShopVO mealShopVO;

    float distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }

    public float getDistanceInFeet() {
        return distanceInFeet;
    }
}
