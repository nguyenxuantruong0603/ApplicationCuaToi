package com.example.applicationcuatoi.view.detailmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivityDetailMovieBinding;

public class DetailMovieActivity extends AppCompatActivity {

    private int pStatus = 0;
    private final Handler handler = new Handler();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ActivityDetailMovieBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie);

        binding.imgPlay.setOnClickListener(v -> Toast.makeText(DetailMovieActivity.this, "Playing", Toast.LENGTH_SHORT).show());

        binding.btnBuyCart.setOnClickListener(v -> Toast.makeText(DetailMovieActivity.this, "Buy Successfully", Toast.LENGTH_SHORT).show());

        new Thread(() -> {
            while (pStatus <= 60) {
                handler.post(() -> {
                    binding.progressBar.setProgress(pStatus);
                    binding.txtProgress.setText(pStatus + "");
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pStatus++;
            }
        }).start();

    }
}