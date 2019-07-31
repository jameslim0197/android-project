package com.example.firstproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterMember extends AppCompatActivity {
    private static final int PHOTO_REQUEST_CODE_ = 1;
    public static final String EXTRA_FULL_NAME = "com.example.firstproject.FULL_NAME";
    public static final String EXTRA_PHONE = "com.example.firstproject.PHONE";
    public static final String EXTRA_EMAIL_ADDRESS = "com.example.firstproject.EMAIL_ADDRESS";
    public static final String EXTRA_PASSWORD = "com.example.firstproject.PASSWORD";
    public static final String EXTRA_CONFIRM_PASSWORD = "com.example.firstproject.CONFIRM_PASSWORD";
    public static final String EXTRA_SHOP_NAME = "com.example.firstproject.SHOP_NAME";
    public static final String EXTRA_ADDRESS = "com.example.firstproject.ADDRESS";
    public static final String EXTRA_REFERENCE = "com.example.firstproject.REFERENCE";
    public static final String EXTRA_FILE_PATH = "com.example.firstproject.FILE_PATH";

    private String cameraFilePath;

    @BindView(R.id.etFullName) EditText fullNameEditText;
    @BindView(R.id.etPhone) EditText phoneEditText;
    @BindView(R.id.etPassword) EditText passwordEditText;
    @BindView(R.id.etConfirmPassword) EditText confirmPasswordEditText;
    @BindView(R.id.etEmail) EditText emailEditText;
    @BindView(R.id.etShopName) EditText shopNameEditText;
    @BindView(R.id.etAddress) EditText addressEditText;
    @BindView(R.id.etReference) EditText referenceEditText;
    @BindView(R.id.ivKtp) ImageView ktpImageView;
    @BindView(R.id.ivNpwp) ImageView npwpImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_member);
        ButterKnife.bind(this);

        ktpImageView.setOnClickListener(new GetPhotoClick());
    }

    public void getPhoto() {
        try {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", createImageFile()));

            Intent chooser = new Intent(Intent.ACTION_CHOOSER);
            chooser.putExtra(Intent.EXTRA_INTENT, galleryIntent);
            chooser.putExtra(Intent.EXTRA_TITLE, "Select camera or gallery");

            Intent[] intentArray = { cameraIntent };
            chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);

            startActivityForResult(chooser, PHOTO_REQUEST_CODE_);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void getRegisterResponse(View view) {
        Intent registerIntent = new Intent(this, DisplayRegisterResponse.class);

        String fullName = fullNameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword  = confirmPasswordEditText.getText().toString();
        String shopName = shopNameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String reference = referenceEditText.getText().toString();

        registerIntent.putExtra(EXTRA_FULL_NAME, fullName);
        registerIntent.putExtra(EXTRA_PHONE, phone);
        registerIntent.putExtra(EXTRA_EMAIL_ADDRESS, email);
        registerIntent.putExtra(EXTRA_PASSWORD, password);
        registerIntent.putExtra(EXTRA_CONFIRM_PASSWORD, confirmPassword);
        registerIntent.putExtra(EXTRA_SHOP_NAME, shopName);
        registerIntent.putExtra(EXTRA_ADDRESS, address);
        registerIntent.putExtra(EXTRA_REFERENCE, reference);
        registerIntent.putExtra(EXTRA_FILE_PATH, cameraFilePath);

        startActivity(registerIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_REQUEST_CODE_ && resultCode == RESULT_OK && data != null) {
             Uri selectedPhoto = data.getData();
             ktpImageView.setImageURI(selectedPhoto);
             Bitmap bitmap =(Bitmap) data.getExtras().get("data");
             ktpImageView.setImageBitmap(bitmap);
             ktpImageView.setImageURI(Uri.parse(cameraFilePath));
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //This is the directory in which the file will be created. This is the default location of Camera photos
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for using again
        cameraFilePath = "file://" + image.getAbsolutePath();
        return image;
    }

    class GetPhotoClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            getPhoto();
        }
    }
}
