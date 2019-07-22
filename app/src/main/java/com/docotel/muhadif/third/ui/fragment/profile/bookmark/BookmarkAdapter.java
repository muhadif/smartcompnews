package com.docotel.muhadif.third.ui.fragment.profile.bookmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.helper.GlideUtil;
import com.docotel.muhadif.third.R;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<News> newsList;
    private OnItemClickListener onItemClickListener;

    public BookmarkAdapter(Context context) {
        this.context = context;
    }

    public void setBookmarkList(List<News> newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_news, parent, false );
        viewHolder = new BookmarkAdapter.NormalHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        News news = newsList.get(position);

        final NormalHolder normalHolder = (NormalHolder) holder;
        normalHolder.Binding(news, context);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }



    public class NormalHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView tvItemNewsTitle;
        private ImageView ivItemNews;
        private News news;

        public NormalHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            tvItemNewsTitle = itemView.findViewById(R.id.tv_item__news_title);
            ivItemNews = itemView.findViewById(R.id.iv_item_news);
        }

        public void Binding(final News news, final Context context){
            this.news = news;
            tvItemNewsTitle.setText(news.getTitle());
            Glide.with(context)
                    .load(news.getImageUrl())
                    .apply(GlideUtil.options)
                    .into(ivItemNews);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(news);
                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(News news);
    }

    public void SetOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
