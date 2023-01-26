package com.example.hoseinse.hotelreservastion.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoseinse.hotelreservastion.R;
import com.example.hoseinse.hotelreservastion.MainMenu.MainPage.Services;
import com.example.hoseinse.hotelreservastion.Utils.Font;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class gridviewAdapter extends BaseAdapter {
    private final Context context;



     public gridviewAdapter(Context mContext){
        this.context = mContext;
        setResources();
    }


    private void setResources() {

        new Services(context);
    }


    @Override
    public int getCount() {
        return Services.getSize();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null ){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView  = inflater.inflate(R.layout.gridviewlayout,null);
         }

        ImageView MainImage = (ImageView) convertView.findViewById(R.id.gridImage);
        TextView MainText = (TextView) convertView.findViewById(R.id.gridtext);

        MainImage.setImageDrawable(Services.getDrawables(position));
        MainText.setText(Services.getTexts(position));
        MainText.setTypeface(Font.Font(context));
        return convertView;
    }
}
