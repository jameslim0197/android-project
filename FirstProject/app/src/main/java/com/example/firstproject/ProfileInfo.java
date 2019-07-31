package com.example.firstproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileInfo {
    @SerializedName("id_member")
    @Expose
    private String idMember;
    @Expose
    private String nama;
    @SerializedName("nama_toko")
    @Expose
    private String namaToko;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String alamat;
    @Expose
    private String status;
    @SerializedName("status_name")
    @Expose
    private String statusName;
    @SerializedName("photo_ktp")
    @Expose
    private String photoKtp;
    @SerializedName("photo_npwp")
    @Expose
    private String photoNpwp;
    @SerializedName("limit_credit")
    @Expose
    private String limitCredit;
    @SerializedName("use_credit")
    @Expose
    private String useCredit;
    @SerializedName("sisa_credit")
    @Expose
    private String sisaCredit;
    @SerializedName("current_pass")
    @Expose
    private String currentPass;
    @SerializedName("tgl_reg")
    @Expose
    private String tglReg;

    public String getIdMember() {
        return idMember;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getPhotoKtp() {
        return photoKtp;
    }

    public String getPhotoNpwp() {
        return photoNpwp;
    }

    public String getLimitCredit() {
        return limitCredit;
    }

    public String getUseCredit() {
        return useCredit;
    }

    public String getSisaCredit() {
        return sisaCredit;
    }

    public String getCurrentPass() {
        return currentPass;
    }

    public String getTglReg() {
        return tglReg;
    }
}
