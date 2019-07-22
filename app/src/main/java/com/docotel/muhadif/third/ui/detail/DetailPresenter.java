package com.docotel.muhadif.third.ui.detail;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.docotel.muhadif.smartcompnews.data.model.request.DetailNewsRequest;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.smartcompnews.data.model.response.NewsDetail;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackDetailNews;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackInterface;
import com.docotel.muhadif.third.helper.ApplicationHelper;
import com.docotel.muhadif.third.helper.FTAes;
import com.docotel.muhadif.third.helper.JNIHelper;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.base.BasePresenter;
import com.google.gson.Gson;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DetailPresenter implements BasePresenter, GetCallbackInterface {
    private Context context;
    private DetailView view;
    private News news;
    private NewsDetail newsDetail;
    private PreferenceHelper preferenceHelper;

    public DetailPresenter(DetailView detailView) {
        this.view = detailView;
    }


    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate(Context context) {
        this.context = context;
        view.initView();
        view.initListener();
        preferenceHelper = new PreferenceHelper(context);

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void getData(String newsId, String newsType){

        DetailNewsRequest detailNewsRequest = new DetailNewsRequest(1,newsId, ApplicationHelper.getUID(), newsType);

        String data = new Gson().toJson(detailNewsRequest);
        String encryptedData = FTAes.encrypt(data, JNIHelper.getEncryption());
        RequestManager.getDetailNews(ApplicationHelper.getUID(),
                1,
                encryptedData,
                0,
                JNIHelper.getEncryption(),
                JNIHelper.getApi(),
                context,
                new GetCallbackDetailNews(this));

    }

    public void onGetDataSucess(int requestId, String rawData) {
        Gson gson = new Gson();

        this.newsDetail = gson.fromJson(rawData, NewsDetail.class);

        view.showData(newsDetail);
    }

    public void onGetDataFailure(String s) {
    }

    public void bookNews(News news, Boolean state){
        if(state) {
            List<News> bookmarkNews = preferenceHelper.getList(PreferenceHelper.BOOKMARK_NEWS, News[].class);
            LinkedList<News> bookmarkLinked = new LinkedList<>();

            if (bookmarkNews != null) {

                bookmarkLinked.addAll(bookmarkNews);
                for (News news1 : bookmarkLinked) {

                    if (news1.getNewsId().equals(news.getNewsId())) {
                        bookmarkLinked.remove(news1);
                        break;}
                }

                view.isBooked(false);
                Toast.makeText(context, "Berita telah dihapus", Toast.LENGTH_SHORT).show();
                preferenceHelper.putList(PreferenceHelper.BOOKMARK_NEWS, bookmarkLinked);

            }



        }
        else {
            List<News> bookmarkNews = preferenceHelper.getList(PreferenceHelper.BOOKMARK_NEWS, News[].class);
            LinkedList<News> bookmarkLinked = new LinkedList<>();

            if (bookmarkNews != null) {
                bookmarkLinked.addAll(bookmarkNews);
                bookmarkLinked.add(news);
            } else {
                bookmarkLinked.add(news);

            }

            view.isBooked(true);
            Toast.makeText(context, "Berita telah ditambahkan", Toast.LENGTH_SHORT).show();
            preferenceHelper.putList(PreferenceHelper.BOOKMARK_NEWS, bookmarkLinked);
        }

    }

    public void isBooked(String newsId) {
        List<News> bookmarkNews = preferenceHelper.getList(PreferenceHelper.BOOKMARK_NEWS, News[].class);
        Boolean state = false;

        if (bookmarkNews != null) {
            for (News news : bookmarkNews) {

                if (news.getNewsId().equals(newsId)) {
                    state = true;
                    break;}
                else {state = false;}
            }
        } else {state = false;}


        view.isBooked(state);
    }

}
