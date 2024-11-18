package com.dblanco.nicestart;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //added a transparent shape to the traditional action bar
//        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.transparent));
//
//        TextView dateView = (TextView) findViewById(R.id.mydate);
//        setDate(dateView);
//
//    }
//
//    public void setDate(TextView view) {
////        String str = String.format("%tc", new Date());
////        view.setText(str);
////
//        Date today = Calendar.getInstance().getTime();//getting date
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"); //formating according to my needs
//        String date = formatter.format(today);
//        view.setText(date);
//
    }

    // Method for Signup button
    public void openLogin(View v) {
        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);
    }

    // Method for Signup button
    public void openMain(View v) {
        Intent intent = new Intent(Signup.this, Main.class);
        startActivity(intent);
    }

}