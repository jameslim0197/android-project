package com.example.firstproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionHistoryResponse {
    @SerializedName("data")
    @Expose
    private List<TransactionData> data = null;

    @SerializedName("err_code")
    @Expose
    private String errCode;

    @SerializedName("err_name")
    @Expose
    private String errName;

    public List<TransactionData> getData() {
        return data;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrName() {
        return errName;
    }
}
