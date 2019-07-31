package com.example.firstproject;

public class ApiUtils {
    public static final String BASE_URL = "https://andtechnology.me/gts/api/member/";

    public static GTSApi getGTSApi() {
        return RetrofitClient.getClient(BASE_URL).create(GTSApi.class);
    }
}
