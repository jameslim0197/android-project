package com.example.firstproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberResponse {
    @SerializedName("err_code")
    @Expose
    private String errCode;
    @SerializedName("err_msg")
    @Expose
    private String errMsg;
    @SerializedName("profile_info")
    @Expose
    private ProfileInfo profileInfo;

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }
}
