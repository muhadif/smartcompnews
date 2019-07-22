package com.docotel.muhadif.third.ui.fragment.news.list;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.docotel.muhadif.smartcompnews.data.model.request.NewsRequest;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackInterface;
import com.docotel.muhadif.third.helper.ApplicationHelper;
import com.docotel.muhadif.third.helper.EndlessRecyclerViewScrollListener;
import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.ui.detail.DetailActivity;
import com.docotel.muhadif.third.ui.fragment.news.NewsFragment;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArticleFragment extends Fragment implements ArticleView {
    private static final String ARG_PARAM1 = "param1";
    public static final int NEWS_CODE = 101;
    public static final int ARTICLE_CODE = 102;
    public static final int NEWEST_CODE = 103;
    public static final int NEW_NEWS = 14;
    public static final int SAVED_NEWS = 15;

    private int CODE;
    private ArticlePresenter presenter;
    private Context context;
    private View view;
    private RecyclerView rvArticle;
    private SwipeRefreshLayout swipeArticleList;
    private ArticleAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<News> news = new ArrayList<>();
    private String newsType;
    private ShimmerFrameLayout shimmerRv;
    private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    private FloatingActionButton fabBackTop;
    public static int page = 1;
    private boolean isFirstLoad;

    public static ArticleFragment newInstance(int code) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, code);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        presenter = new ArticlePresenter(this);
        presenter.onAttach(context);
        adapter = new ArticleAdapter(context);
        adapter.setArticles(news);
        isFirstLoad = true;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            CODE = getArguments().getInt(ARG_PARAM1);
            switch (CODE){
                case ARTICLE_CODE:
                    newsType = "article";
                    break;
                case NEWS_CODE:
                    newsType = "news";
                    break;
                case NEWEST_CODE:
                    newsType = "all";
                    break;
                default:
                    newsType = "news";

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View views = inflater.inflate(R.layout.fragment_article, container, false);
        this.view = views;
        presenter.onCreateView(view);

        return views;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void showData(List<News> data) {

        if(isFirstLoad){
            this.news.clear();
        }
        this.news.addAll(data);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void initView(View view) {
        shimmerRv = view.findViewById(R.id.shimmer_rv);
        rvArticle = view.findViewById(R.id.rv_article);
        swipeArticleList = view.findViewById(R.id.swipe_list_article);
        rvArticle.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(context);
        rvArticle.setLayoutManager(layoutManager);
        rvArticle.setAdapter(adapter);
    }



    @Override
    public void initListener() {
        adapter.SetOnItemClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(News news) {
                Intent detailNews = new Intent(context, DetailActivity.class);

                detailNews.putExtra(DetailActivity.EXTRA_NEWS_ID, news.getNewsId());
                detailNews.putExtra(DetailActivity.EXTRA_NEWS_TYPE, news.getmTypeInEnglish());
                detailNews.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(detailNews);
            }
        });

        endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                isFirstLoad = false;
                getData(page);

            }
        };

        rvArticle.addOnScrollListener(endlessRecyclerViewScrollListener);

        swipeArticleList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isFirstLoad = true;
                page = 1;
                getData(page);
            }
        });

    }

    @Override
    public void startTask() {

        swipeArticleList.setRefreshing(true);
        if(isFirstLoad) {
            shimmerRv.startShimmerAnimation();
            shimmerRv.setVisibility(View.VISIBLE);
            rvArticle.setVisibility(View.GONE);
        }
    }

    @Override
    public void finishedTask() {

        swipeArticleList.setRefreshing(false);
        if(isFirstLoad) {
            shimmerRv.stopShimmerAnimation();
            shimmerRv.setVisibility(View.GONE);
            rvArticle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void failureTask(String message) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_SHORT);

        snackbar.show();
    }

    @Override
    public void info(String message) {

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        page = 1;
        isFirstLoad = true;
        getData(page);

    }

    @Override
    public void noInternet() {
        new AlertDialog.Builder(context)
                .setTitle("No internet Connection")
                .setMessage("Please Turn on your internet connection")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                })
                .show();

    }

    public void getData(int page) {

        NewsRequest newsRequest = new NewsRequest(page, 10, 1, "", ApplicationHelper.getUID(), newsType);
        presenter.getNews(ApplicationHelper.getUID(), 1, CODE, newsRequest);
    }

}
