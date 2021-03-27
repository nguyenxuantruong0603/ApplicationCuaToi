package com.example.applicationcuatoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.datamodel.user.User;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.Holder> {

    private List<User> userList;
    private Context context;

    public InformationAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User user = userList.get(position);
        holder.tvAdress.setText(user.getAddress());
        holder.tvAge.setText(user.getAge() + "");
        holder.tvEmail.setText(user.getEmail());
        holder.tvPhoneNumber.setText(user.getPhoneNumber() + "");
        holder.tvSex.setText(user.getSex());
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        }
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView tvEmail;
        TextView tvAge;
        TextView tvSex;
        TextView tvAdress;
        TextView tvPhoneNumber;


        public Holder(@NonNull View itemView) {
            super(itemView);

            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvSex = itemView.findViewById(R.id.tvSex);
            tvAdress = itemView.findViewById(R.id.tvAdress);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);

        }
    }
}
