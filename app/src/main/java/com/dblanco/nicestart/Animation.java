package com.dblanco.nicestart;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import android.widget.TextView;


public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();

        // Animación para el logo
        ImageView thunder = findViewById(R.id.logosplash);
        android.view.animation.Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.scalerotate);
        thunder.startAnimation(logoAnimation);

        // Animación para el texto
        TextView textView = findViewById(R.id.textView);
        android.view.animation.Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        textView.startAnimation(textAnimation);

        // Cargar la imagen de fondo con Glide
        ImageView mSea = findViewById(R.id.backView);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mSea);
    }

    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Animation
                        .this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);



            }
        }, 5000);


    }

}