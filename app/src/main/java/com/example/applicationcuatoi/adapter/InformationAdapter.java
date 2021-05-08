package com.example.applicationcuatoi.adapter;

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
    private ItemUserBinding binding;

    public InformationAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_user, parent, false);

        View view = binding.getRoot();


        return new Holder(view);
    }

    public List<User> getUserList() {
            return userList;
    }

    public void removeItem(int position) {

    }

    public void restoreItem() {

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User user = userList.get(position);
        binding.tvAdress.setText("Địa Chỉ: " + user.getAddress());
        binding.tvAge.setText("Tuổi: " + user.getAge());
        binding.tvEmail.setText("Email: " + user.getEmail());
        binding.tvPhoneNumber.setText("Số Điện Thoại:" + user.getPhoneNumber());
        binding.tvSex.setText("Giới Tính: " + user.getSex());
        if (user.getSex().equals("Nam")) {
            binding.layoutLine.setBackgroundResource(R.drawable.background_layout_male);
        } else {
            binding.layoutLine.setBackgroundResource(R.drawable.background_layout_female);
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

        public Holder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
