package com.example.hoseinse.hotelreservastion.MainMenu.MainPage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.hoseinse.hotelreservastion.R;


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public class Services {
    static Drawable[] imageResources = new Drawable[4];
    static String[] texts = new String[4];

    public Services(Context context){
        imageResources[0] = context.getDrawable(R.drawable.restaurant);
        texts[0] = "سفارش غذا";
        imageResources[1] = context.getDrawable(R.drawable.roomservice);
        texts[1] = "خدمات اتاق";
        imageResources[2] = context.getDrawable(R.drawable.spawellness);
        texts[2] = "اب گرم و سلامت";
        imageResources[3] = context.getDrawable(R.drawable.entertainment);
        texts[3] = "سرگرمی";
    }

    public static void setTexts(String[] texts) {
        Services.texts = texts;
    }

    public static void setDrawables(Drawable[] drawables) {

        Services.imageResources = drawables;
    }

    public static Drawable getDrawables(int p) {

        return imageResources[p];
    }
    public static int getSize(){
        return imageResources.length;
    }
    public static String getTexts(int p) {
        return texts[p];
    }
}
