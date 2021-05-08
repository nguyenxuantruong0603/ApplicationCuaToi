package com.example.applicationcuatoi.view.ui.information;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.InformationAdapter;
import com.example.applicationcuatoi.databinding.FragmentInformationBinding;
import com.example.applicationcuatoi.utils.SwipeHelper;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class InformationFragment extends Fragment {

    private InformationAdapter informationAdapter;
    private  FragmentInformationBinding binding;
    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_information, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InformationViewModel informationViewModel = new ViewModelProvider(this).get(InformationViewModel.class);

        informationViewModel.getListUser();

        informationViewModel.getUserMutableLiveData().observe(getViewLifecycleOwner(), users -> {

            informationAdapter = new InformationAdapter(users, getContext());

            binding.rcInformation.setAdapter(informationAdapter);

        });

        SwipeHelper swipeHelper = new SwipeHelper(getContext()) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Remove",
                        0,
                        Color.parseColor("#E63636"),
                        pos -> {
                            final String item = informationAdapter.getUserList().get(pos).getEmail();
                            Toast.makeText(getApplicationContext(), "You clicked Remove " + item, Toast.LENGTH_SHORT).show();

                            Snackbar snackbar = Snackbar.make(binding.rcInformation, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                            snackbar.setAction("UNDO", view -> {
                            });
                            snackbar.setActionTextColor(Color.YELLOW);
                            snackbar.show();
                        }
                ));

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Like",
                        0,
                        Color.parseColor("#F4B525"),
                        pos -> {
                            final String item = informationAdapter.getUserList().get(pos).getEmail();
                            Toast.makeText(getApplicationContext(), "You clicked like on " + item, Toast.LENGTH_LONG).show();
                        }));

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Share",
                        0,
                        Color.parseColor("#3691E6"),
                        pos -> {
                            final String item = informationAdapter.getUserList().get(pos).getEmail();
                            Toast.makeText(getApplicationContext(), "You clicked share on " + item, Toast.LENGTH_LONG).show();
                        }));
            }
        };
        swipeHelper.attachToRecyclerView(binding.rcInformation);

    }
}