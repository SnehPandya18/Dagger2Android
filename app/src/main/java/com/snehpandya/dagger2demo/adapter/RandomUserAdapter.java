package com.snehpandya.dagger2demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.snehpandya.dagger2demo.R;
import com.snehpandya.dagger2demo.model.Result;
import com.snehpandya.dagger2demo.view.MainActivity;
import com.snehpandya.dagger2demo.viewholder.RandomUserViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by sneh.pandya on 16/11/17.
 */

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private MainActivity mMainActivity;
    private Glide mGlide;

    private List<Result> mResults = new ArrayList<>();

    //TODO: 16. Inject

    @Inject
    public RandomUserAdapter(MainActivity mainActivity, Glide glide) {
        this.mMainActivity = mainActivity;
        this.mGlide = glide;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        Result result = mResults.get(position);
        holder.textView.setText(String.format("%s %s", result.getName().getFirst(), result.getName().getLast()));
        mGlide.with(mMainActivity)
                .load(result.getPicture().getLarge())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public void setItems(List<Result> results) {
        mResults = results;
        notifyDataSetChanged();
    }
}
