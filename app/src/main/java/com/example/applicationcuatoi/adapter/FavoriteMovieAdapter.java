package com.example.applicationcuatoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;
import com.example.applicationcuatoi.utils.ActionBottomDialogFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteMovieAdapter extends RecyclerView.Adapter<FavoriteMovieAdapter.Holder> {

    private List<TheMovie> theMovieList;
    private Context context;

    public FavoriteMovieAdapter(List<TheMovie> theMovieList, Context context) {
        this.theMovieList = theMovieList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_movie, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TheMovie theMovie = theMovieList.get(position);
        holder.tvTitle.setText(theMovie.getTitle());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + theMovie.getBackdropPath()).into(holder.imgAvatar);

        holder.itemView.setOnClickListener(v -> {
            ActionBottomDialogFragment addPhotoBottomDialogFragment = ActionBottomDialogFragment.newInstance(theMovie);
            addPhotoBottomDialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(),
                    ActionBottomDialogFragment.TAG);
        });
    }

    @Override
    public int getItemCount() {
        if (theMovieList != null) {
            return theMovieList.size();
        }
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView imgAvatar;
        private TextView tvTitle;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }


    }
}
