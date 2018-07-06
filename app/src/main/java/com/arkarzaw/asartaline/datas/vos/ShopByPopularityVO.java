package com.arkarzaw.asartaline.datas.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByPopularityVO implements BaseVO {

    String shopByPupularityId;

    @SerializedName("mealShop")
    MealShopVO mealShopVO;

    public String getShopByPupularityId() {
        return shopByPupularityId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }
}
