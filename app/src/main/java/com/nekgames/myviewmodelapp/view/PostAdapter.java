package com.nekgames.myviewmodelapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nekgames.myviewmodelapp.R;
import com.nekgames.myviewmodelapp.model.UrlPost;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Nadya Bryzgalova on 23.08.2021.
 **/
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<UrlPost> posts;
    private LayoutInflater mInflater;

    PostAdapter(Context context, List<UrlPost> data) {
        this.mInflater = LayoutInflater.from(context);
        this.posts = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String postTitle = posts.get(position).getTitle();
        holder.titleTextView.setText(postTitle);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.postTitle);
        }

    }

}