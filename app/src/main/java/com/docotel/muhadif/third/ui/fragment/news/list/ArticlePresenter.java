package com.docotel.muhadif.third.ui.fragment.news.list;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.docotel.muhadif.smartcompnews.data.model.request.NewsRequest;
import com.docotel.muhadif.smartcompnews.data.model.response.AllResponse;
import com.docotel.muhadif.smartcompnews.data.model.response.ArticleResponse;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.smartcompnews.data.model.response.NewsResponse;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackInterface;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackNews;
import com.docotel.muhadif.third.helper.ConnectivityHelper;
import com.docotel.muhadif.third.helper.FTAes;
import com.docotel.muhadif.third.helper.JNIHelper;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.base.BaseFragmentPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.ARTICLE_CODE;
import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.NEWEST_CODE;
import static com.docotel.muhadif.third.ui.fragment.news.list.ArticleFragment.NEWS_CODE;

public class ArticlePresenter implements BaseFragmentPresenter, GetCallbackInterface {
    private ArticleView mView;
    private Context context;
    private PreferenceHelper preferenceHelper;
    private List<News> newsList = new ArrayList<>();

    public ArticlePresenter(ArticleView mView) {
        this.mView = mView;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        preferenceHelper = new PreferenceHelper(context);
    }

    @Override
    public void onCreateView(View view) {
        mView.initView(view);
        mView.initListener();
    }

    @Override
    public void onViewCreatated(View view) {

    }

    @Override
    public void onDetach() {

    }

//    public void getSavedNews(String deviceId, int communityId, int requestId, NewsRequest newsRequest) {
//        mView.startTask();
//
//        if (requestId == ARTICLE_CODE) {
//            if (preferenceHelper.getString(PreferenceHelper.ARTICLE_DATA) != null) {
//                String json = preferenceHelper.getString(PreferenceHelper.ARTICLE_DATA);
//
//                ArticleResponse articleResponse = new Gson().fromJson(json, ArticleResponse.class);
//
//                if (articleResponse.getList().getNews().size() > 0) {
//                    mView.showData(articleResponse.getList().getNews());
//                    mView.finishedTask();
//                    return;
//                }
//            }
//        } else if (requestId == NEWS_CODE) {
//            if (preferenceHelper.getString(PreferenceHelper.NEWS_DATA) != null) {
//                String json = preferenceHelper.getString(PreferenceHelper.NEWS_DATA);
//
//                NewsResponse newsResponse = new Gson().fromJson(json, NewsResponse.class);
//
//                if (newsResponse.getList().getNews().size() > 0) {
//                    mView.showData(newsResponse.getList().getNews());
//                    mView.finishedTask();
//                    return;
//                }
//            }
//        } else if (requestId == NEWEST_CODE) {
//            if (preferenceHelper.getString(PreferenceHelper.NEWEST_DATA) != null) {
//                String json = preferenceHelper.getString(PreferenceHelper.NEWEST_DATA);
//
//                AllResponse allResponse = new Gson().fromJson(json, AllResponse.class);
//
//                if (allResponse.getList().getNews().size() > 0) {
//                    mView.showData(allResponse.getList().getNews());
//                    mView.finishedTask();
//                    return;
//                }
//            }
//        }
//
//        getNews(deviceId, communityId, requestId, newsRequest);
//
//    }

    public void getNews(String deviceId, int communityId, int requestId, NewsRequest newsRequest) {
        if(ConnectivityHelper.isConnectedToNetwork(context)) {
            mView.startTask();
            newsList.clear();
            String data = new Gson().toJson(newsRequest);
            String encryptedData = FTAes.encrypt(data, JNIHelper.getEncryption());
            RequestManager.getNews(deviceId,
                    communityId,
                    encryptedData,
                    requestId,
                    JNIHelper.getEncryption(),
                    JNIHelper.getApi(),
                    context,
                    new GetCallbackNews(this));
        } else {
            mView.noInternet();
        }
    }


    public void onGetDataSucess(int requestId, String data) {
        if (requestId == ARTICLE_CODE) {
            ArticleResponse articleResponse = new Gson().fromJson(data, ArticleResponse.class);
            if(articleResponse != null) {
                addToList(articleResponse.getList().getNews());
            }
        } else if (requestId == NEWS_CODE) {
            NewsResponse newsResponse = new Gson().fromJson(data, NewsResponse.class);
            if(newsResponse != null) {
                addToList(newsResponse.getList().getNews());
            }
        } else if (requestId == NEWEST_CODE) {
            AllResponse allResponse = new Gson().fromJson(data, AllResponse.class);
            if(allResponse != null) {
                addToList(allResponse.getList().getNews());
            }
        }
        mView.finishedTask();
    }

    public void onGetDataFailure(String message) {

        mView.failureTask(message);
        mView.finishedTask();

    }

    private void addToList(List<News> newsList) {
        if (newsList.size() > 0) {
           this.newsList.addAll(newsList);
           mView.showData(this.newsList);

        }
    }


}

