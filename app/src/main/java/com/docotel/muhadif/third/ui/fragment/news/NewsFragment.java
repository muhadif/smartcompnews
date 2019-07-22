package com.docotel.muhadif.third.ui.fragment.news;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.base.BaseFragment;
import com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.UUID;

import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.ARTICLE_CODE;
import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.NEWEST_CODE;
import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.NEWS_CODE;


public class NewsFragment extends BaseFragment implements NewsView {
    private NewsPresenter presenter;
    private Context context;
    private View view;
    private TabLayout tlNews;
    private ViewPager viewPager;
    private NewsViewPagerAdapter adapter;

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        presenter = new NewsPresenter(this);
        presenter.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.fragment_news, container, false);
        this.view = views;
        presenter.onCreateView(view);

        return views;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewCreatated(view);
    }

    @Override
    public void showData(String rawData) {

    }

    @Override
    public void initView(View view) {
        viewPager = view.findViewById(R.id.vp_news);
        tlNews = view.findViewById(R.id.tl_news);

        setupViewPager();
    }

    @Override
    public void initListener() {

    }

    private void setupViewPager(){
        adapter = new NewsViewPagerAdapter(getChildFragmentManager(), context);
        adapter.addFragment(ArticleFragment.newInstance(NEWEST_CODE), "Newest");
        adapter.addFragment(ArticleFragment.newInstance(NEWS_CODE), "News");
        adapter.addFragment(ArticleFragment.newInstance(ARTICLE_CODE), "Article");
        viewPager.setAdapter(adapter);
        tlNews.setupWithViewPager(viewPager);

    }

    @Override
    public void startTask() {

    }

    @Override
    public void finishedTask() {

    }

    @Override
    public void failureTask(String message) {

    }

    @Override
    public void info(String message) {

    }


}
