package com.example.hoseinse.hotelreservastion.MainMenu.Resturant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.hoseinse.hotelreservastion.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class Foods {
    static String[] foodsname = new String[4];
    static Drawable[] foodsImage = new Drawable[4];
    static String[] foodsPrice = new String[4];

    public static String getFoodsname(int p) {
        return foodsname[p];
    }

    public static Drawable getFoodsImage(int p) {
        return foodsImage[p];
    }


    public static String getFoodsPrice(int p) {
        return foodsPrice[p];
    }
    public static int getSize(){
        return foodsname.length;
    }

    public Foods(Context context){
        foodsImage[0] = context.getDrawable(R.drawable.restaurant);
        foodsImage[1] = context.getDrawable(R.drawable.roomservice);
        foodsImage[2] = context.getDrawable(R.drawable.spawellness);
        foodsImage[3] = context.getDrawable(R.drawable.entertainment);
        foodsname[0] = ("چلو گوشت");
        foodsname[1] = ("چلو مرغ");
        foodsname[2] = ("چلو خورشت قیمه ");
        foodsname[3] = ("ممد پلو");
        foodsPrice[0] = ("23000 تومان");
        foodsPrice[1] = ("10000 تومان");
        foodsPrice[2] = ("14000 تومان");
        foodsPrice[3] = ("16000 تومان");

    }
}
