package com.snehpandya.dagger2demo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.snehpandya.dagger2demo.R;

/**
 * Created by sneh.pandya on 16/11/17.
 */

public class RandomUserViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;

    public RandomUserViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_name);
        imageView = itemView.findViewById(R.id.image_user);
    }
}
