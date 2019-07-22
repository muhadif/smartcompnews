package com.docotel.muhadif.third.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.smartcompnews.data.model.response.NewsDetail;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.base.BaseActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import static com.docotel.muhadif.third.ui.fragment.profile.bookmark.BookmarkActivity.BOOKMARK_CHANGED;

public class DetailActivity extends BaseActivity implements DetailView {

    public static final String EXTRA_NEWS_ID = "extra_news_id";
    public static final String EXTRA_NEWS_TYPE = "extra_news_type";
    private DetailPresenter presenter;
    private TextView tvDescDetail, tvDescTitle;
    private ImageView ivDetail;
    private News news;
    private Menu menu;
    private String newsId, newsType;
    private boolean bookmark = false;
    CollapsingToolbarLayout collapsingToolbarDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent().getStringExtra(EXTRA_NEWS_ID) != null && getIntent().getStringExtra(EXTRA_NEWS_TYPE) != null){
            newsId = getIntent().getStringExtra(EXTRA_NEWS_ID);
            newsType = getIntent().getStringExtra(EXTRA_NEWS_TYPE);
        }

        presenter = new DetailPresenter(this);
        presenter.onCreate(this);
        presenter.getData(newsId, newsType);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.top_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_share:
                shareNews();
                return true;

            case R.id.menu_bookmark:
                if(news != null) {
                    if(PreferenceHelper.isLogin(this)) {
                        presenter.bookNews(news, bookmark);
                        Intent bookmarkChange = new Intent();
                        bookmarkChange.putExtra("changed", true);
                        setResult(BOOKMARK_CHANGED, bookmarkChange);
                    } else {
                        Toast.makeText(this, "Anda belum login, harap login terlebih dahulu", Toast.LENGTH_SHORT).show();
                    }

                }
                return true;

            case android.R.id.home:
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNews() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, news.getTitle() );
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Judul Berita : " + news.getTitle() + "\n" + Html.fromHtml(news.getShortDescription())  + " (gambar : " + news.getImageUrl() + ")");
        startActivity(Intent.createChooser(sharingIntent, "Share at"));
    }

    @Override
    public void showData(NewsDetail newsDetail) {
        this.news = newsDetail.getNews();

        if(PreferenceHelper.isLogin(this)) {
            presenter.isBooked(newsId);
        }

        collapsingToolbarDetail.setTitle("");
        tvDescTitle.setText(news.getTitle());
        tvDescDetail.setText(Html.fromHtml(news.getDescription()));

        Glide.with(this)
                .load(news.getImageUrl())
                .into(ivDetail);

    }

    @Override
    public void initView() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivDetail = findViewById(R.id.iv_detail);
        tvDescTitle = findViewById(R.id.tv_detail_news);
        tvDescDetail = findViewById(R.id.tv_desc_detail);
        collapsingToolbarDetail = findViewById(R.id.collapsing_toolbar_detail);
        collapsingToolbarDetail.setTitleEnabled(false);

    }

    @Override
    public void initListener() {

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

    public void isBooked(Boolean state){
        bookmark = state;
        if(state) {
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white_24dp));

        }
         else {

             menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_border_white_24dp));
        }
    }



}
