package com.docotel.muhadif.third.ui.fragment.profile;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.docotel.muhadif.smartcompnews.data.model.response.LoginResponse;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.helper.GlideUtil;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.base.BaseFragment;
import com.docotel.muhadif.third.ui.detail.DetailActivity;
import com.docotel.muhadif.third.ui.fragment.news.NewsFragment;
import com.docotel.muhadif.third.ui.fragment.news.list.ArticleAdapter;
import com.docotel.muhadif.third.ui.fragment.profile.bookmark.BookmarkActivity;
import com.docotel.muhadif.third.ui.fragment.profile.bookmark.BookmarkAdapter;
import com.docotel.muhadif.third.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.docotel.muhadif.third.ui.login.LoginActivity.LOGIN_SUCCESS;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment implements ProfileView {

    private static final int LOGIN = 101;
    private ProfilePresenter presenter;
    private Context context;
    private View view;
    private TextView tvNameProfile;
    private TextView tvEmailProfile;
    private Button btnLoginProfile;
    private BookmarkAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<News> newsList = new ArrayList<>();
    private LoginResponse account = null;
    private CircleImageView ivProfile;
    private CardView cvBookmark;
    private boolean logged = false;

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        this.view = view;
        presenter.onCreateView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewCreatated(view);
        
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        presenter = new ProfilePresenter(this);
        presenter.onAttach(context);
        adapter = new BookmarkAdapter(context);
        adapter.setBookmarkList(newsList);
    }


    @Override
    public void showData(List<News> newsList) {

    }

    @Override
    public void showAccount(LoginResponse account) {
        this.account = account;

        Glide.with(this)
                .load(account.getImageUrl())
                .apply(GlideUtil.options)
                .into(ivProfile);

        tvNameProfile.setText(account.getLastName()) ;
        tvEmailProfile.setText(account.getEmail());
    }

    @Override
    public void initView(View view) {
        cvBookmark = view.findViewById(R.id.cv_bookmark);
        ivProfile = view.findViewById(R.id.iv_profile);
        tvEmailProfile = view.findViewById(R.id.tv_email_profile);
        tvNameProfile = view.findViewById(R.id.tv_name_profile);
        btnLoginProfile = view.findViewById(R.id.btn_login_profile);

        checkLogin();
    }

    @Override
    public void initListener() {
        btnLoginProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(logged) {
                    presenter.logout(account.getEmail());
                } else {
                    Intent loginIntent = new Intent(context, LoginActivity.class);
                    getActivity().startActivityForResult(loginIntent, LOGIN);
                }
            }
        });


        cvBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PreferenceHelper.isLogin(context)){
                    Intent bookmarkIntent = new Intent(context, BookmarkActivity.class);
                    startActivity(bookmarkIntent);
                } else {
                    Toast.makeText(context, "Please login first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        adapter.SetOnItemClickListener(new BookmarkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(News news) {
                Intent detailNews = new Intent(context, DetailActivity.class);
                detailNews.putExtra(DetailActivity.EXTRA_NEWS_ID, news.getNewsId());
                detailNews.putExtra(DetailActivity.EXTRA_NEWS_TYPE, news.getmTypeInEnglish());
                detailNews.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(detailNews);
            }
        });
    }

    @Override
    public void checkLogin(){
        if(PreferenceHelper.isLogin(context)){
            logged = true;
            presenter.getLoggedAccount();
            btnLoginProfile.setText("LOGOUT");
            tvEmailProfile.setVisibility(View.VISIBLE);
            tvNameProfile.setVisibility(View.VISIBLE);
        } else {
            logged = false;
            btnLoginProfile.setText("LOGIN");
            tvEmailProfile.setVisibility(View.GONE);
            tvNameProfile.setVisibility(View.GONE);
            account = null;
            Glide.with(this)
                    .load(R.drawable.ic_account_circle_grey_24dp)
                    .apply(GlideUtil.options)
                    .into(ivProfile);
        }
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
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LOGIN && resultCode == LOGIN_SUCCESS) {
            Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show();
            checkLogin();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        checkLogin();
    }
}
