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

        progressbarShowVote();
        initView();

    }

    private void initView() {
        title = getIntent().getStringExtra("TITLE");
        overview = getIntent().getStringExtra("OVERVIEW");
        date = getIntent().getStringExtra("DATE");
        votecount = getIntent().getIntExtra("VOTECOUNT", 0);
        voteaverage = getIntent().getDoubleExtra("VOTEAVERAGE", 0.0);
        avatar = getIntent().getStringExtra("AVATAR");

        binding.tvDetailTitle.setText(title);
        binding.tvDetailOverView.setText(overview);
        binding.tvDetailDate.setText(date);
        binding.tvDetailVote.setText(votecount + "");

        convert = String.valueOf(voteaverage).replace(".", "");
    }

    private void progressbarShowVote() {
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