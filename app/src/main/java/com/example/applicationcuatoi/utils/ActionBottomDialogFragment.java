package com.example.applicationcuatoi.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ActionBottomDialogFragment extends BottomSheetDialogFragment {

    public static final String TAG = "ActionBottomDialog";
    static TheMovie themovie;
    boolean Heart = false;

    public static ActionBottomDialogFragment newInstance(TheMovie theMovie) {
        themovie = theMovie;
        return new ActionBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ConstraintLayout bottomSheet;
        TextView tvVoteCount;
        TextView tvDate;
        TextView tvTitle;
        TextView tvOverView;
        TextView tvLanguage;
        TextView tvVoteAverage;
        ImageView imgHeart;

        bottomSheet = view.findViewById(R.id.bottom_sheet);
        tvVoteCount = view.findViewById(R.id.tvVoteCount);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDate = view.findViewById(R.id.tvDate);
        tvOverView = view.findViewById(R.id.tvOverView);
        tvLanguage = view.findViewById(R.id.tvLanguage);
        tvVoteAverage = view.findViewById(R.id.tvVoteAverage);
        imgHeart = view.findViewById(R.id.imgHeart);

        Picasso.with(view.getContext()).load("https://image.tmdb.org/t/p/w500" + themovie.getPosterPath()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                bottomSheet.setBackground(new BitmapDrawable(bitmap));

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
        tvVoteCount.setText(themovie.getVoteCount() + " Vote");
        tvTitle.setText(themovie.getTitle());
        tvOverView.setText(themovie.getOverview());
        tvLanguage.setText(themovie.getOriginalLanguage());
        tvVoteAverage.setText(themovie.getVoteAverage() + " imdb");
        tvDate.setText(themovie.getReleaseDate() + "");

        imgHeart.setOnClickListener(v -> {

            if (Heart == true) {
                imgHeart.setBackgroundResource(R.drawable.heart_color);
                Heart = false;
            } else {
                imgHeart.setBackgroundResource(R.drawable.heart);
                Heart = true;

            }
        });

    }

}
