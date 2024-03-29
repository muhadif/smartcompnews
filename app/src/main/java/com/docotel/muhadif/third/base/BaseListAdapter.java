package com.docotel.muhadif.third.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseListAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> items;
    protected Context context;

    protected OnItemClickListener onItemClickListener;

    public BaseListAdapter(Context context) {
        this.context = context;
        items = new ArrayList<T>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected View getView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(getItemResourceLayout(viewType), parent, false);
    }

    protected abstract int getItemResourceLayout(int viewType);

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bind(items.get(position));
    }

    public T getItem(int position) {
        return items.get(position);
    }

    private void add(T item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addAll(List<T> items) {
        for (T item : items) {
            add(item);
        }
    }

    public void addOrUpdate(T item) {
        int i = items.indexOf(item);
        if (i >= 0) {
            items.set(i, item);
            notifyItemChanged(i);
        } else {
            add(item);
        }
    }

    public void addOrUpdate(List<T> items) {
        int size = items.size();
        for (int i = 0; i < size; i++) {
            T item = items.get(i);
            int x = items.indexOf(item);
            if (x >= 0) {
                items.set(x, item);
            } else {
                add(item);
            }
        }
        notifyDataSetChanged();
    }

    public void remove(T item) {
        int position = items.indexOf(item);
        if (position > -1) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void insert(T item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void clear() {
        items.clear();
        notifyItemRangeRemoved(0, getItemCount());
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
