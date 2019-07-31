package com.example.firstproject;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface GTSApi {
    @POST("login")
    @FormUrlEncoded
    Call<MemberResponse> postLogin(@FieldMap Map<String, String> params);

    @Multipart
    @POST("reg")
    @FormUrlEncoded
    Call<MemberResponse> postRegister(@PartMap Map<String, String> params, @Part MultipartBody.Part file);

    @POST("history_transaksi")
    @FormUrlEncoded
    Call<TransactionHistoryResponse> postTransactionHistory(@FieldMap Map<String, String> params);
}
