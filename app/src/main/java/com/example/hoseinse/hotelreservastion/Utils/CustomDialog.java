package com.example.hoseinse.hotelreservastion.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoseinse.hotelreservastion.MainMenu.MainPage.MainActivity;
import com.example.hoseinse.hotelreservastion.MainMenu.RoomService.ServicesActivity;
import com.example.hoseinse.hotelreservastion.R;

import org.w3c.dom.Text;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Class<ServicesActivity> activityTogo;
    Activity context;
    Dialog dialog;
    String titlestring,firststring,secondstring;
    Button firstOption,secondOption;
    TextView title;
    boolean goTomain = true;
    public CustomDialog(@NonNull Activity context) {
        super(context);
        this.context = context;


    }
    public CustomDialog(@NonNull Activity context,boolean goTomain,Class<ServicesActivity> activityTogo) {
        super(context);
        this.context = context;
        this.activityTogo = activityTogo;
        this.goTomain = goTomain;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_order);

        firstOption = (Button) findViewById(R.id.InplaceOrder);
        secondOption = (Button) findViewById(R.id.InresturantOrder);
        TextView title = (TextView) findViewById(R.id.orderdialogtitle);

        title.setText(titlestring);
        firstOption.setText(firststring);
        secondOption.setText(secondstring);

        firstOption.setTypeface(Font.Font(context));
        secondOption.setTypeface(Font.Font(context));
        firstOption.setOnClickListener(this);
        secondOption.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.InplaceOrder:
                if(goTomain) {
                    context.startActivity(new Intent(firstOption.getContext(), MainActivity.class));
                    dismiss();
                    context.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    context.finish();
                }else {
                    context.startActivity(new Intent(firstOption.getContext(), activityTogo));
                    dismiss();
                    context.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    context.finish();
                }
                break;
            case R.id.InresturantOrder:
                if (goTomain) {
                    context.startActivity(new Intent(getContext(), MainActivity.class));
                    dismiss();
                    context.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    context.finish();
                }else {
                    context.startActivity(new Intent(getContext(), activityTogo));
                    dismiss();
                    context.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    context.finish();
                }
                break;
        }
    }

    public void setText(String title,String first,String Second){
        this.titlestring = title;
        firststring = first;
        secondstring = Second;
    }


}
