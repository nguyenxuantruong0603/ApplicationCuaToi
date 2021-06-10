package com.example.applicationcuatoi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ItemUserBinding;
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
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_user, parent, false);
        return new Holder(binding);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void removeItem(int position) {

    }

    public void restoreItem() {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User user = userList.get(position);
        holder.binding.tvAdress.setText("Địa Chỉ: " + user.getAddress());
        holder.binding.tvAge.setText("Tuổi: " + user.getAge());
        holder.binding.tvEmail.setText("Email: " + user.getEmail());
        holder.binding.tvPhoneNumber.setText("Số Điện Thoại:" + user.getPhoneNumber());
        holder.binding.tvSex.setText("Giới Tính: " + user.getSex());
        if (user.getSex().equals("Nam")) {
            holder.binding.layoutLine.setBackgroundResource(R.drawable.background_layout_male);
        } else {
            holder.binding.layoutLine.setBackgroundResource(R.drawable.background_layout_female);
        }
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        }
        return 0;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public Holder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
