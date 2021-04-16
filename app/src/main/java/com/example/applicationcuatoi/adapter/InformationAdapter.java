package com.example.applicationcuatoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User user = userList.get(position);
        binding.tvAdress.setText(user.getAddress());
        binding.tvAge.setText(String.valueOf(user.getAge()));
        binding.tvEmail.setText(user.getEmail());
        binding.tvPhoneNumber.setText(String.valueOf(user.getPhoneNumber()));
        binding.tvSex.setText(user.getSex());
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
