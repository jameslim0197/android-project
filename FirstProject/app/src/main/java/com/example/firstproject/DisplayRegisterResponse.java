package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayRegisterResponse extends AppCompatActivity {
    @BindView(R.id.btOk) Button okButton;
    @BindView(R.id.tvRegisterResponse) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_register_response);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra(RegisterMember.EXTRA_FULL_NAME);
        String phone = intent.getStringExtra(RegisterMember.EXTRA_PHONE);
        String password = intent.getStringExtra(RegisterMember.EXTRA_PASSWORD);
        String confirmPassword = intent.getStringExtra(RegisterMember.EXTRA_CONFIRM_PASSWORD);
        String email = intent.getStringExtra(RegisterMember.EXTRA_EMAIL_ADDRESS);
        String shopName = intent.getStringExtra(RegisterMember.EXTRA_SHOP_NAME);
        String address = intent.getStringExtra(RegisterMember.EXTRA_ADDRESS);
        String reference = intent.getStringExtra(RegisterMember.EXTRA_REFERENCE);
        String filePath = intent.getStringExtra(RegisterMember.EXTRA_FILE_PATH);

        Map<String,String> params = new HashMap<>();
        params.put("nama_member", fullName);
        params.put("email", email);
        params.put("password", password);
        params.put("alamat", address);
        params.put("phone", phone);
        params.put("nama_toko", shopName);
//        params.put("photo_ktp", email);
//        params.put("photo_npwp", password);

        File file = new File(filePath);

        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");

        GTSApi mGTSApi = ApiUtils.getGTSApi();

        Call<MemberResponse> call = mGTSApi.postRegister(params, part);

        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                if(!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                MemberResponse memberResponse = response.body();

                String registerResponse = "";
                registerResponse += "ErrCode: " + memberResponse.getErrCode() + "\n";
                registerResponse += "ErrMsg: " + memberResponse.getErrMsg() + "\n";
                textView.setText(registerResponse);
                Log.d("onResponse", "no error");
            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {
                textView.setText(t.getMessage());
                Log.d("onFailure", "fail");
            }
        });
    }

    public void okButton(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
