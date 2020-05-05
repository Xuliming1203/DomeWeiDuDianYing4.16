package com.bw.domeweidudianying416.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseActivity;
import com.bw.domeweidudianying416.contracl.SearchContracl;
import com.bw.domeweidudianying416.presenter.SearchPresenter;

public class MovieSearchActivity extends BaseActivity<SearchPresenter> implements SearchContracl.View {

    @Override
    protected int layoutId() {
        return R.layout.activity_movie_search;
    }

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(Object object) {

    }

    @Override
    public void fshibai(Throwable throwable) {

    }
}
