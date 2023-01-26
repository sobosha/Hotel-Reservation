package com.example.sobhan.hotelreservastion.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoseinse.hotelreservastion.MainMenu.Resturant.resturant;
import com.example.hoseinse.hotelreservastion.R;
import com.example.hoseinse.hotelreservastion.MainMenu.Resturant.Foods;
import com.example.hoseinse.hotelreservastion.Utils.Font;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;
import com.travijuu.numberpicker.library.NumberPicker;

import java.util.ArrayList;
import java.util.HashMap;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class foodlistadapter  extends BaseAdapter implements View.OnClickListener {
    static TextView[] counter = new TextView[Foods.getSize()];
    static HashMap hashMap;
    Context context;
    int posit;
    public foodlistadapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return Foods.getSize();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        if (convertView == null){
            final LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.foodlists,null);
        }
        posit = position;
        ImageView image = (ImageView) convertView.findViewById(R.id.foodimage);
        TextView foodName = (TextView) convertView.findViewById(R.id.foodnametext);
        TextView foodPrice = (TextView) convertView.findViewById(R.id.foodprice);
        Button minesbtn = (Button) convertView.findViewById(R.id.minesmines);
        Button plusbtn  = (Button) convertView.findViewById(R.id.plusplus);
        plusbtn.setTag(position);
        minesbtn.setTag(position);
        counter[position] = (TextView) convertView.findViewById(R.id.foodcountertext);
        counter[position].setText("0");
        counter[position].setTag(position);
        resturant.counter[position] = counter[position];
        final View finalConvertView = convertView;
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) finalConvertView.findViewById(R.id.foodcountertext);
                if((Integer.parseInt(text.getText().toString())+1) <= 25) {
                    text.setText((Integer.parseInt(text.getText().toString()) + 1) + "");
                }
            }
        });
        minesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) finalConvertView.findViewById(R.id.foodcountertext);
                if ((Integer.parseInt(text.getText().toString())-1) >= 0 )
                text.setText((Integer.parseInt(text.getText().toString())-1)+"");
            }
        });
        image.setImageDrawable(Foods.getFoodsImage(position));
        foodPrice.setText(Foods.getFoodsPrice(position));
        foodName.setText(Foods.getFoodsname(position));
        foodName.setTypeface(Font.BoldFont(context));
        foodPrice.setTypeface(Font.Font(context));
        return convertView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plusplus:

        }
    }
}
