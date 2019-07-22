package com.docotel.muhadif.third.ui.fragment.profile.bookmark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity implements BookmarkView{

    private static final int DETAIL_CODE = 102;
    public static final int BOOKMARK_CHANGED = 103 ;
    private BookmarkPresenter presenter;
    private RecyclerView rvBookmark;
    private BookmarkAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<News> newsList = new ArrayList<>();
    private Toolbar toolbarBookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        presenter = new BookmarkPresenter(this);
        presenter.onCreate(this);

    }

    @Override
    public void initView() {
        toolbarBookmark = findViewById(R.id.toolbar_bookmark);
        setSupportActionBar(toolbarBookmark);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Bookmark");

        adapter = new BookmarkAdapter(this);
        adapter.setBookmarkList(newsList);
        rvBookmark = findViewById(R.id.rv_bookmark);
        rvBookmark.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(this);
        rvBookmark.setLayoutManager(layoutManager);
        rvBookmark.setAdapter(adapter);
    }

    @Override
    public void showData(List<News> newsList) {

        this.newsList.clear();
        this.newsList.addAll(newsList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initListener() {
        adapter.SetOnItemClickListener(new BookmarkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(News news) {
                Intent detailNews = new Intent(BookmarkActivity.this, DetailActivity.class);
                detailNews.putExtra(DetailActivity.EXTRA_NEWS_ID, news.getNewsId());
                detailNews.putExtra(DetailActivity.EXTRA_NEWS_TYPE, news.getmTypeInEnglish());
                startActivityForResult(detailNews, DETAIL_CODE);
            }
        });

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


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DETAIL_CODE) {
            if(resultCode == BOOKMARK_CHANGED) {
                presenter.getBookmark();
            }
        }

    }
}
