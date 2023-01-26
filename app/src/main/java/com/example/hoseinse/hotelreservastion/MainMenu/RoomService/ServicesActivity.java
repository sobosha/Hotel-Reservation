package com.example.hoseinse.hotelreservastion.MainMenu.RoomService;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoseinse.hotelreservastion.R;
import com.example.hoseinse.hotelreservastion.Utils.Font;
import com.vansuita.gaussianblur.GaussianBlur;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ServicesActivity extends AppCompatActivity implements View.OnClickListener {
    TextView firstimagetext;
    TextView secondimagetext;
    View firstImage,secondImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        setTitle("");
        toolbarset();
        coordinatesset();




    }

    private void coordinatesset() {
        firstimagetext = (TextView) findViewById(R.id.textView1);
        secondimagetext = (TextView) findViewById(R.id.textView2);
        firstImage =  findViewById(R.id.firstimage);
        secondImage = findViewById(R.id.secondimage);
        firstImage.setOnClickListener(this);
        secondImage.setOnClickListener(this);

        firstimagetext.setTypeface(Font.Font(this));
        secondimagetext.setTypeface(Font.Font(this));

    }



    private void toolbarset() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar.getChildAt(0) instanceof TextView){
            TextView title = (TextView) toolbar.getChildAt(0);
            title.setText("خدمات اتاق");
            title.setTypeface(Font.Font(this));
        }
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstimage:
                Snackbar.make(v,"Your Request Accepted",Snackbar.LENGTH_LONG).show();

                break;
            case R.id.secondimage:
                Snackbar.make(v,"Your Request Accepted",Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
