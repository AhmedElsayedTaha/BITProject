package com.example.bitprojecttask;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView imageView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        url = getIntent().getStringExtra("url");
        Glide.with(this).load(url).placeholder(R.drawable.placeholderimg).into(imageView);
    }

    @OnClick(R.id.close)
    public void closeBtn(){
        finish();
    }


}


