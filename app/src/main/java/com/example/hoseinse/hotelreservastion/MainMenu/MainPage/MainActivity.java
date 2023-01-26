package com.example.hoseinse.hotelreservastion.MainMenu.MainPage;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hoseinse.hotelreservastion.Adapter.gridviewAdapter;
import com.example.hoseinse.hotelreservastion.MainMenu.RoomService.ServicesActivity;
import com.example.hoseinse.hotelreservastion.R;
import com.example.hoseinse.hotelreservastion.MainMenu.Resturant.resturant;
import com.example.hoseinse.hotelreservastion.Utils.CustomDialog;
import com.example.hoseinse.hotelreservastion.Utils.Font;

import java.util.Timer;
import java.util.TimerTask;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public GridView gridView;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        toolbarset();
        gridView = (GridView) findViewById(R.id.gridview);
        gridviewAdapter adapter = new gridviewAdapter(this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        login();
    }

    private void toolbarset() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar.getChildAt(0) instanceof TextView){
            TextView title = (TextView) toolbar.getChildAt(0);
            title.setTypeface(Font.Font(this));
        }
        setSupportActionBar(toolbar);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,resturant.class));
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                break;
            case 1:
                startActivity(new Intent(this,ServicesActivity.class));
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
        }
    }

    public void login()
    {
        final CircularProgressButton btn;
        final Bitmap icon;
        final RelativeLayout greenlayout= (RelativeLayout) findViewById(R.id.Rel);
        final RelativeLayout mylayout= (RelativeLayout) findViewById(R.id.login_layout);
        AnimationDrawable anim= (AnimationDrawable) mylayout.getBackground();
        final EditText id= (EditText) findViewById(R.id.User);
        final EditText pass= (EditText) findViewById(R.id.Pass);
        final TextView hoteldaryoosh= (TextView) findViewById(R.id.hotelD);
        anim.setEnterFadeDuration(1);
        anim.setExitFadeDuration(1000);
        anim.start();
        btn=(CircularProgressButton) findViewById(R.id.btn_id);
        final RelativeLayout mainactivity= (RelativeLayout) findViewById(R.id.main_activ);

        icon= BitmapFactory.decodeResource(getResources(),R.drawable.success);
        final int[] chek = {0};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chek[0]==0) {
                    btn.startAnimation();

                    Timer time=new Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btn.doneLoadingAnimation(Color.GREEN,icon);

                                    final int cx= (int) btn.getX()+btn.getWidth()/2;
                                    final int cy= (int) btn.getY()+btn.getHeight()/2;

                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                        Animator anim = ViewAnimationUtils.createCircularReveal(greenlayout, cx, cy, 0,1500);
                                        anim.setDuration(1500);
                                        anim.addListener(new Animator.AnimatorListener() {
                                            @Override
                                            public void onAnimationStart(Animator animation) {
                                                greenlayout.setVisibility(View.VISIBLE);
                                            }

                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                id.setVisibility(View.INVISIBLE);
                                                pass.setVisibility(View.INVISIBLE);
                                                hoteldaryoosh.setVisibility(View.INVISIBLE);
                                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                                    Animator animrevert = ViewAnimationUtils.createCircularReveal(greenlayout, cx, cy, 1500, 0);
                                                    animrevert.setDuration(1500);
                                                    animrevert.addListener(new Animator.AnimatorListener() {
                                                        @Override
                                                        public void onAnimationStart(Animator animation) {
                                                            mainactivity.setVisibility(View.VISIBLE);

                                                        }

                                                        @Override
                                                        public void onAnimationEnd(Animator animation) {
                                                            greenlayout.setVisibility(View.GONE);
                                                            TranslateAnimation translateAnimation=new TranslateAnimation(0,0,0,500);
                                                            translateAnimation.setFillAfter(true);
                                                            translateAnimation.setDuration(1500);
                                                            btn.startAnimation(translateAnimation);

                                                        }

                                                        @Override
                                                        public void onAnimationCancel(Animator animation) {

                                                        }

                                                        @Override
                                                        public void onAnimationRepeat(Animator animation) {

                                                        }
                                                    });
                                                    animrevert.start();
                                                }
                                            }

                                            @Override
                                            public void onAnimationCancel(Animator animation) {

                                            }

                                            @Override
                                            public void onAnimationRepeat(Animator animation) {

                                            }
                                        });
                                        anim.start();



                                    }


                                }
                            });


                        }
                    },2000);
                    chek[0] = 1;
                }
                else
                {
                    btn.revertAnimation();
                }
            }
        });
    }
}

/*
mainactivity.setVisibility(View.VISIBLE);
        TranslateAnimation translateAnimation=new TranslateAnimation(0,0,0,500);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(1500);
        btn.startAnimation(translateAnimation);*/
