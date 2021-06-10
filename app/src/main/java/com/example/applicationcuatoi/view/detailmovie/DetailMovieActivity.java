package com.example.applicationcuatoi.view.detailmovie;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivityDetailMovieBinding;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private int pStatus = 0;
    private String voteConvert;
    private double voteAverage;
    private ActivityDetailMovieBinding binding;
    private boolean isCheckSound = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.pho_khong_mua);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie);

        binding.cardView.setOnClickListener(v -> {
            if (!isCheckSound) {
                player.start();
                isCheckSound = true;
            } else {
                player.pause();
                isCheckSound = false;

            }
        });

        binding.btnBuyCart.setOnClickListener(v -> Toast.makeText(DetailMovieActivity.this, "Buy Successfully", Toast.LENGTH_SHORT).show());

        initView();
        progressbarShowVote();
        setupToolbar();

    }


    @SuppressLint("SetTextI18n")
    private void initView() {
        String title = getIntent().getStringExtra("TITLE");
        String overview = getIntent().getStringExtra("OVERVIEW");
        String date = getIntent().getStringExtra("DATE");
        Integer votecount = getIntent().getIntExtra("VOTECOUNT", 0);
        voteAverage = getIntent().getDoubleExtra("VOTEAVERAGE", 0.0);
        String avatar = getIntent().getStringExtra("AVATAR");

        voteConvert = String.valueOf(voteAverage).replace(".", "");


        binding.tvDetailTitle.setText(title);
        binding.tvDetailOverView.setText(overview);
        binding.tvDetailDate.setText(date);
        binding.tvDetailVote.setText(votecount + "");
        binding.tvOverView2.setText(overview);

        Picasso.get().load("https://image.tmdb.org/t/p/w500" + avatar).into(binding.imgDetailAvatar);
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + avatar).into(binding.imageView);
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + avatar).into(binding.imageView2);

    }

    private void setupToolbar() {
        binding.toolbarDetail.setNavigationIcon(R.drawable.ic_arrow_back);
        binding.toolbarDetail.setNavigationOnClickListener(v -> finish());
    }


    @SuppressLint("SetTextI18n")
    private void progressbarShowVote() {

        if (voteConvert != null) {
            new Thread(() -> {
                while (pStatus <= (Integer.parseInt(voteConvert))) {
                    handler.post(() -> {
                        binding.progressBar.setProgress(pStatus);
                        binding.txtProgress.setText(voteAverage + "");
                        Log.e("status", pStatus + "");
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }).start();
        }
    }
}