package com.arkarzaw.asartaline.datas;

import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WarDeeResponse {

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    @SerializedName("apiVersion")
    String apiVersion;

    @SerializedName("astlWarDee")
    List<WarDeeVO> warDeeVOS;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<WarDeeVO> getWarDeeVOS() {
        return warDeeVOS;
    }
}
