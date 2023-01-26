package com.example.hoseinse.hotelreservastion.MainMenu.Resturant;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoseinse.hotelreservastion.Adapter.foodlistadapter;
import com.example.hoseinse.hotelreservastion.MainMenu.MainPage.MainActivity;
import com.example.hoseinse.hotelreservastion.R;
import com.example.hoseinse.hotelreservastion.Utils.CustomDialog;
import com.example.hoseinse.hotelreservastion.Utils.Font;
import com.travijuu.numberpicker.library.NumberPicker;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class resturant extends AppCompatActivity implements View.OnClickListener {
    public static TextView[] counter = new TextView[Foods.getSize()];
    Button orderfood;
    ListView foodlist;
    foodlistadapter foodadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant);
        setToolbar();
        new Foods(this);
        foodlist = (ListView) findViewById(R.id.foodlist);
        foodadapter = new foodlistadapter(this);
        foodlist.setAdapter(foodadapter);

        Button orderingbtn = (Button) findViewById(R.id.foodOrderBtn);
        orderingbtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.foodOrderBtn:
                CustomDialog customDialog = new CustomDialog(this);
                customDialog.setText("انتخاب کنید ؟","در اتاق میل میکنم","در رستوران غذا اماده شود");
                customDialog.show();

                break;
        }

    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar.getChildAt(0) instanceof TextView){
            TextView title = (TextView) toolbar.getChildAt(0);
            title.setText("سفارش غذا");
            title.setTypeface(Font.Font(this));
        }
        setSupportActionBar(toolbar);
        setTitle("");
        orderfood  = (Button) findViewById(R.id.foodOrderBtn);
        orderfood.setTypeface(Font.Font(this));

    }


}
