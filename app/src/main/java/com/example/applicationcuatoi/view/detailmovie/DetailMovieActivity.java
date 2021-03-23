package com.example.applicationcuatoi.view.detailmovie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivityDetailMovieBinding;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {

    private int pStatus = 0;
    private final Handler handler = new Handler();
    private String title, overview, date, convert, avatar;
    private Integer votecount;
    private double voteaverage;
    private ActivityDetailMovieBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie);

        binding.imgPlay.setOnClickListener(v -> Toast.makeText(DetailMovieActivity.this, "Playing", Toast.LENGTH_SHORT).show());

        binding.btnBuyCart.setOnClickListener(v -> Toast.makeText(DetailMovieActivity.this, "Buy Successfully", Toast.LENGTH_SHORT).show());

        initView();
        progressbarShowVote();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        title = getIntent().getStringExtra("TITLE");
        overview = getIntent().getStringExtra("OVERVIEW");
        date = getIntent().getStringExtra("DATE");
        votecount = getIntent().getIntExtra("VOTECOUNT", 0);
        voteaverage = getIntent().getDoubleExtra("VOTEAVERAGE", 0.0);
        avatar = getIntent().getStringExtra("AVATAR");

        convert = String.valueOf(voteaverage).replace(".", "");

        binding.tvDetailTitle.setText(title);
        binding.tvDetailOverView.setText(overview);
        binding.tvDetailDate.setText(date);
        binding.tvDetailVote.setText(votecount + "");
        Picasso.with(this).load("https://image.tmdb.org/t/p/w500" + avatar).into(binding.imgDetailAvatar);

    }

    @SuppressLint("SetTextI18n")
    private void progressbarShowVote() {

        if (convert != null) {
            new Thread(() -> {
                while (pStatus <= Integer.parseInt(convert)) {
                    handler.post(() -> {
                        binding.progressBar.setProgress(pStatus);
                        binding.txtProgress.setText(voteaverage + "");
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