package com.nekgames.myviewmodelapp.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekgames.myviewmodelapp.R;

import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getPosts().observe(Objects.requireNonNull(getActivity()), new Observer<List<UrlPost>>() {
            @Override
            public void onChanged(List<UrlPost> urlPosts) {
                RecyclerView recyclerView = getActivity().findViewById(R.id.postsRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                PostAdapter adapter = new PostAdapter(getContext(), urlPosts);
                //adapter.setClickListener(getActivity());
                recyclerView.setAdapter(adapter);
            }
        });
    }

}