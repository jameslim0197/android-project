package com.example.firstproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionData {
    @SerializedName("id_transaksi")
    @Expose
    private String idTransaksi;

    @Expose
    private String total;

    @SerializedName("tgl_transaksi")
    @Expose
    private String tglTransaksi;

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getTotal() {
        return total;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }
}
