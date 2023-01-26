package com.example.hoseinse.hotelreservastion.Utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Locale;


public class Font {

    static public Typeface Font(Context context){
        AssetManager assetManager = context.getApplicationContext().getAssets();
        Typeface font = Typeface.createFromAsset(assetManager,"fonts/BNazanin.ttf");
        return font;
    }
    static public Typeface BoldFont(Context context){
        AssetManager assetManager = context.getApplicationContext().getAssets();
        Typeface font = Typeface.createFromAsset(assetManager,"fonts/BNazaninBold.ttf");
        return font;

    }

}
