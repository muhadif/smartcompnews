package com.docotel.muhadif.third.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract <T> void bind(T t);
}
