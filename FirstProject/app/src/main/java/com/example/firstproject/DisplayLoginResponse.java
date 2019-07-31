package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayLoginResponse extends AppCompatActivity {
    private ArrayList<String> listTanggal = new ArrayList<>();
    private ArrayList<String>  totals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_login_response);
        ButterKnife.bind(this);

        initArrayList();
        initRecyclerView();

        // Get email and password string from calling activity
        Intent intent = getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL);
        String password = intent.getStringExtra(MainActivity.PASSWORD);

        Map<String,String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        GTSApi mGTSApi = ApiUtils.getGTSApi();

        Call<MemberResponse> call = mGTSApi.postLogin(params);

        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                if(!response.isSuccessful()) {
//                    textView.setText("Code: " + response.code());
                    return;
                }

                MemberResponse memberResponse = response.body();

                String loginResponse = "";
                loginResponse += "ErrCode: " + memberResponse.getErrCode() + "\n";
                loginResponse += "ErrMsg: " + memberResponse.getErrMsg() + "\n";
                Log.d("onResponse", "no error");
            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {
//                textView.setText(t.getMessage());
                Log.d("onFailure", "fail");
            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recyclerView= findViewById(R.id.rvRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listTanggal, totals, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void  initArrayList() {
        listTanggal.add("1");
        listTanggal.add("2");
        listTanggal.add("3");
        listTanggal.add("4");
        listTanggal.add("5");
        listTanggal.add("6");
        listTanggal.add("7");
        listTanggal.add("8");
        totals.add("10");
        totals.add("20");
        totals.add("30");
        totals.add("40");
        totals.add("50");
        totals.add("60");
        totals.add("70");
        totals.add("80");
    }
}
