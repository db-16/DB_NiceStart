package com.dblanco.nicestart;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class openProfile extends AppCompatActivity {

    private LottieAnimationView animationViewgh,animationViewyt,animationViewmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView chica = findViewById(R.id.chica);

        animationViewgh = findViewById(R.id.animationViewGh);
        animationViewgh.setAnimation(R.raw.github);             //Nombre de la animacion en res/raw
        animationViewgh.setRepeatCount(LottieDrawable.INFINITE);

        animationViewyt = findViewById(R.id.animationViewYt);
        animationViewyt.setAnimation(R.raw.youtube);             //Nombre de la animacion en res/raw
        animationViewyt.setRepeatCount(LottieDrawable.INFINITE);

        animationViewmail = findViewById(R.id.animationViewMail);
        animationViewmail.setAnimation(R.raw.mail);             //Nombre de la animacion en res/raw
        animationViewmail.setRepeatCount(LottieDrawable.INFINITE);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
//                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .circleCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(chica);

    }

}