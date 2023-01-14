package com.rmstar.rupeshsagar.sr28239.webpro;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rmstar.rupeshsagar.sr28239.webpro.databinding.ActivitySlapshBinding;

public class Slapsh extends AppCompatActivity {
    Animation top,blwl;
    ActivitySlapshBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_slapsh);
        setContentView(R.layout.activity_slapsh);
        top= AnimationUtils.loadAnimation(this,R.anim.top);
        blwl=AnimationUtils.loadAnimation(this,R.anim.below);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.slashImage.setAnimation(top);
        binding.textlast.setAnimation(blwl);
        binding.textView4.setAnimation(blwl);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // overridePendingTransition(R.anim.top,R.anim.top);
                startActivity(new Intent(Slapsh.this,MainActivity.class));
                finish();
            }
        },2500);
    }
}